package com.wang.java_Learning.utils;

import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * SAX模式，数据处理逻辑
 */
public class SheetHandler extends DefaultHandler {

    private SharedStringsTable sst;
    private String lastContents;
    private boolean nextIsString;
    private String  cellPosition;
    private int curRow = 0;
    private int curCol = 0;
    private List<String> rowList = new ArrayList<>();
    private List<List<String>> rowContents=new ArrayList<>();

    public List<List<String>> getRowContents() {
        return rowContents;
    }

    public void setRowContents(List<List<String>> rowContents) {
        this.rowContents = rowContents;
    }

    public SheetHandler(SharedStringsTable sst) {
        this.sst = sst;
    }

    public void startElement(String uri, String localName, String name,
                             Attributes attributes) throws SAXException {
        if(name.equals("c")) {
            // 保证每一列都有值，空单元格空字符串占位
            rowList.add(curCol, "");
            curCol++;

            cellPosition=attributes.getValue("r");
            String cellType = attributes.getValue("t");
            if(cellType != null && cellType.equals("s")) {
                nextIsString = true;
            } else {
                nextIsString = false;
            }
        }
        //System.out.println(cellPosition);
        // 清除缓存内容
        lastContents = "";
    }

    public void endElement(String uri, String localName, String name)
            throws SAXException {
        if (nextIsString) {
            int idx = Integer.parseInt(lastContents);
            lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
            nextIsString = false;
        }
        if (name.equals("v")) {
            // 如果有值，则替换空字符串
            rowList.set(curCol-1, lastContents.trim());
        } else {
            // 如果标签名称为 row ，这说明已到行尾，调用 optRows() 方法
            if (name.equals("row")) {
                rowContents.add(rowList);
                rowList = new ArrayList<>();
                curRow++;
                curCol = 0;
            }
        }
    }

    public void characters(char[] ch, int start, int length)
            throws SAXException {
        lastContents += new String(ch, start, length);
    }



}
