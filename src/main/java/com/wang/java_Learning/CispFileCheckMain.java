package com.wang.java_Learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zengjm
 * @desc CISP 004 和讯数据迁移项目文件核对
 * @date 2019-8-14
 */
public class CispFileCheckMain {

    public static void main(String[] args) throws IOException {

        String dirName = "d:\\Private\\银行\\和讯\\CISP004\\";
        // 交易确认汇总 D3013
        String kdfilename = "CISP-42200000_D3013_V01_3_20240229_01_Z-KD.TXT";
        Map<String, AckTransSum> ackTransSumMapKd = readAckSumFile(dirName + kdfilename);
        String hsfilename = "CISP-42200000_D3013_V01_3_20240229_01_Z-HS.TXT";
        Map<String, AckTransSum> ackTransSumMapHs = readAckSumFile(dirName + hsfilename);

        System.out.println(" ----- 交易确认汇总 D3013 begin  ----- ");
        checkAck(ackTransSumMapKd, ackTransSumMapHs);
        System.out.println(" ----- 交易确认汇总 D3013 end  ----- ");

        // 份额（保有量）汇总 D1014
        kdfilename = "CISP-42200000_D1014_V01_1_20240305_01_Q-KD.TXT";
        Map<String, BalFundSum> balFundSumSumMapKd = readBalFundFile(dirName + kdfilename);
        hsfilename = "CISP-42200000_D1014_V01_1_20240305_01_Q-HS.TXT";
        Map<String, BalFundSum> balFundSumSumMapHs = readBalFundFile(dirName + hsfilename);
        System.out.println(" ----- 份额（保有量）汇总 D1014 begin  ----- ");
        checkBalFund(balFundSumSumMapKd, balFundSumSumMapHs);
        System.out.println(" ----- 份额（保有量）汇总 D1014 end  ----- ");

        // 销售收入情况 D3016
        kdfilename = "CISP-42200000_D3016_V01_1_20240305_01_Q-KD.TXT";
        Map<String, IncomeSum> incomeSumMapKd = readIncomeFile(dirName + kdfilename);
        hsfilename = "CISP-42200000_D3016_V01_1_20240305_01_Q-HS.TXT";
        Map<String, IncomeSum> incomeSumSumMapHs = readIncomeFile(dirName + hsfilename);
        System.out.println(" ----- 销售收入情况 D3016 begin  ----- ");
        checkIncome(incomeSumMapKd, incomeSumSumMapHs);
        System.out.println(" ----- 销售收入情况 D3016 end  ----- ");
    }

    /**
     * 易确认汇总 D3013
     *
     * @param kdMap
     * @param hsMap
     */
    public static void checkAck(Map<String, AckTransSum> kdMap, Map<String, AckTransSum> hsMap) {
        if (kdMap.size() != hsMap.size()) {
            System.out.println("总笔数不一致，金证 " + kdMap.size() + " 恒生 " + hsMap.size());
        }
        int okCount = 0;
        for (Map.Entry<String, AckTransSum> entry : hsMap.entrySet()) {
            AckTransSum ackHs = entry.getValue();
            AckTransSum ackKd = kdMap.get(entry.getKey());
            if (ackKd == null) {
                System.out.println("恒生存在，金证缺失，fundcode + invtp + businesscode=" + entry.getKey() + " " + entry.getValue().toString());
            } else {
                StringBuilder sbDetail = new StringBuilder();
                if (ackKd.getJYBS() != ackHs.getJYBS()) {
                    sbDetail.append("|交易笔数不一致, 恒生 ").append(ackHs.getJYBS()).append(" 金证").append(ackKd.getJYBS());
                }
                if (ackKd.getJYZHS() != ackHs.getJYZHS()) {
                    sbDetail.append("|交易账户数不一致, 恒生 ").append(ackHs.getJYZHS()).append(" 金证").append(ackKd.getJYZHS());
                }
                if (ackKd.getQRFS().compareTo(ackHs.getQRFS()) != 0) {
                    sbDetail.append("|确认份数不一致, 恒生 ").append(ackHs.getQRFS()).append(" 金证").append(ackKd.getQRFS());
                }
                if (ackKd.getQRJE().compareTo(ackHs.getQRJE()) != 0) {
                    sbDetail.append("|确认金额不一致, 恒生 ").append(ackHs.getQRJE()).append(" 金证").append(ackKd.getQRJE());
                }
                if (ackKd.getSXF().compareTo(ackHs.getSXF()) != 0) {
                    sbDetail.append("|手续费不一致, 恒生 ").append(ackHs.getSXF()).append(" 金证").append(ackKd.getSXF());
                }
                if (ackKd.getDLF().compareTo(ackHs.getDLF()) != 0) {
                    sbDetail.append("|代理费不一致, 恒生 ").append(ackHs.getDLF()).append(" 金证").append(ackKd.getDLF());
                }
                if (sbDetail.length() > 0) {
                    System.out.println("fundcode+invtp+businesscode=" + entry.getKey() + "，数据详情 " + sbDetail.toString());
                } else {
                    okCount++;
                }
            }
        }
        System.out.println("HS总笔数 " + hsMap.size() + " ，核对通过 " + okCount + "笔，不一致 " + (hsMap.size() - okCount) + "笔");
        for (Map.Entry<String, AckTransSum> entry : kdMap.entrySet()) {
            AckTransSum hs = hsMap.get(entry.getKey());
            if (hs == null) {
                System.out.println("恒生不存在，金证多，fundcode+invtp+businesscode=" + entry.getKey() + "  " + entry.getValue().toString());
            }
        }
    }

    /**
     * 份额（保有量）汇总 D1014
     *
     * @param kdMap
     * @param hsMap
     */
    public static void checkBalFund(Map<String, BalFundSum> kdMap, Map<String, BalFundSum> hsMap) {
        if (kdMap.size() != hsMap.size()) {
            System.out.println("总笔数不一致，金证 " + kdMap.size() + " 恒生 " + hsMap.size());
        }
        int okCount = 0;
        for (Map.Entry<String, BalFundSum> entry : hsMap.entrySet()) {
            BalFundSum hs = entry.getValue();
            BalFundSum kd = kdMap.get(entry.getKey());
            if (kd == null) {
                System.out.println("恒生存在，金证缺失，fundcode+invtp=" + entry.getKey() + " " + entry.getValue().toString());
            } else {

                /**
                 * 持有人数	CYRS
                 * 持有份数	CYFS
                 * 持有市值	CYSZ
                 */

                StringBuilder sbDetail = new StringBuilder();
                if (kd.getCYRS() != hs.getCYRS()) {
                    sbDetail.append("|持有人数不一致, 恒生 ").append(hs.getCYRS()).append(" 金证").append(kd.getCYRS());
                }
                if (kd.getCYFS().compareTo(hs.getCYFS()) != 0) {
                    sbDetail.append("|持有份数不一致, 恒生 ").append(hs.getCYFS()).append(" 金证").append(kd.getCYFS());
                }
                if (kd.getCYSZ().compareTo(hs.getCYSZ()) != 0) {
                    sbDetail.append("|持有市值不一致, 恒生 ").append(hs.getCYSZ()).append(" 金证").append(kd.getCYSZ());
                }
                if (sbDetail.length() > 0) {
                    System.out.println("fundcode+invtp=" + entry.getKey() + "，详情 " + sbDetail.toString());
                } else {
                    okCount++;
                }
            }
        }
        System.out.println("HS总笔数 " + hsMap.size() + " ，核对通过 " + okCount + "笔，不一致 " + (hsMap.size() - okCount) + "笔");
        for (Map.Entry<String, BalFundSum> entry : kdMap.entrySet()) {
            BalFundSum hs = hsMap.get(entry.getKey());
            if (hs == null) {
                System.out.println("BalFund, 恒生不存在，金证多，fundcode+invtp=" + entry.getKey() + " " + entry.getValue().toString());
            }
        }
    }

    /**
     * 销售收入情况 D3016
     *
     * @param kdMap
     * @param hsMap
     */
    public static void checkIncome(Map<String, IncomeSum> kdMap, Map<String, IncomeSum> hsMap) {
        if (kdMap.size() != hsMap.size()) {
            System.out.println("总笔数不一致，金证 " + kdMap.size() + " 恒生 " + hsMap.size());
        }
        int okCount = 0;
        for (Map.Entry<String, IncomeSum> entry : hsMap.entrySet()) {
            IncomeSum hs = entry.getValue();
            IncomeSum kd = kdMap.get(entry.getKey());
            if (kd == null) {
                System.out.println("恒生存在，金证缺失，key = fundcode + invtp  " + entry.getKey());
            } else {
                StringBuilder sbDetail = new StringBuilder();
                if (kd.getBQSR().compareTo(hs.getBQSR()) != 0) {
                    sbDetail.append("|本期收入不一致, 恒生 ").append(hs.getBQSR()).append(" 金证").append(kd.getBQSR());
                }
                if (kd.getBQSXFSR().compareTo(hs.getBQSXFSR()) != 0) {
                    sbDetail.append("|本期手续费收入不一致, 恒生 ").append(hs.getBQSXFSR()).append(" 金证").append(kd.getBQSXFSR());
                }
                if (kd.getBQRGSXFSR().compareTo(hs.getBQRGSXFSR()) != 0) {
                    sbDetail.append("|本期认购手续费收入不一致, 恒生 ").append(hs.getBQRGSXFSR()).append(" 金证").append(kd.getBQRGSXFSR());
                }
                if (kd.getBQSGSXFSR().compareTo(hs.getBQSGSXFSR()) != 0) {
                    sbDetail.append("|本期申购手续费收入不一致, 恒生 ").append(hs.getBQSGSXFSR()).append(" 金证").append(kd.getBQSGSXFSR());
                }
                if (kd.getBQSHSXFSR().compareTo(hs.getBQSHSXFSR()) != 0) {
                    sbDetail.append("|本期赎回手续费收入不一致, 恒生 ").append(hs.getBQSHSXFSR()).append(" 金证").append(kd.getBQSHSXFSR());
                }
                if (kd.getBQZHSXFSR().compareTo(hs.getBQZHSXFSR()) != 0) {
                    sbDetail.append("|本期转换手续费收入不一致, 恒生 ").append(hs.getBQZHSXFSR()).append(" 金证").append(kd.getBQZHSXFSR());
                }
                if (kd.getBQXSFWFSR().compareTo(hs.getBQXSFWFSR()) != 0) {
                    sbDetail.append("|本期销售服务费收入不一致, 恒生 ").append(hs.getBQXSFWFSR()).append(" 金证").append(kd.getBQXSFWFSR());
                }
                if (kd.getBQKHWHFSR().compareTo(hs.getBQKHWHFSR()) != 0) {
                    sbDetail.append("|本期客户维护费收入不一致, 恒生 ").append(hs.getBQKHWHFSR()).append(" 金证").append(kd.getBQKHWHFSR());
                }
                if (kd.getBQQTSR().compareTo(hs.getBQQTSR()) != 0) {
                    sbDetail.append("|本期其他收入不一致, 恒生 ").append(hs.getBQQTSR()).append(" 金证").append(kd.getBQQTSR());
                }
                if (kd.getBNLJSR().compareTo(hs.getBNLJSR()) != 0) {
                    sbDetail.append("|本年累计收入不一致, 恒生 ").append(hs.getBNLJSR()).append(" 金证").append(kd.getBNLJSR());
                }
                if (kd.getBNLJSXFSR().compareTo(hs.getBNLJSXFSR()) != 0) {
                    sbDetail.append("|本年累计手续费收入不一致, 恒生 ").append(hs.getBNLJSXFSR()).append(" 金证").append(kd.getBNLJSXFSR());
                }
                if (kd.getBNRGSXFSR().compareTo(hs.getBNRGSXFSR()) != 0) {
                    sbDetail.append("|本年认购手续费收入不一致, 恒生 ").append(hs.getBNRGSXFSR()).append(" 金证").append(kd.getBNRGSXFSR());
                }
                if (kd.getBNSGSXFSR().compareTo(hs.getBNSGSXFSR()) != 0) {
                    sbDetail.append("|本年申购手续费收入不一致, 恒生 ").append(hs.getBNSGSXFSR()).append(" 金证").append(kd.getBNSGSXFSR());
                }
                if (kd.getBNSHSXFSR().compareTo(hs.getBNSHSXFSR()) != 0) {
                    sbDetail.append("|本年赎回手续费收入不一致, 恒生 ").append(hs.getBNSHSXFSR()).append(" 金证").append(kd.getBNSHSXFSR());
                }
                if (kd.getBNZHSXFSR().compareTo(hs.getBNZHSXFSR()) != 0) {
                    sbDetail.append("|本年转换手续费收入不一致, 恒生 ").append(hs.getBNZHSXFSR()).append(" 金证").append(kd.getBNZHSXFSR());
                }
                if (kd.getBNXSFWFSR().compareTo(hs.getBNXSFWFSR()) != 0) {
                    sbDetail.append("|本年销售服务费收入不一致, 恒生 ").append(hs.getBNXSFWFSR()).append(" 金证").append(kd.getBNXSFWFSR());
                }
                if (kd.getBNLJKHWHFSR().compareTo(hs.getBNLJKHWHFSR()) != 0) {
                    sbDetail.append("|本年累计客户维护费收入不一致, 恒生 ").append(hs.getBNLJKHWHFSR()).append(" 金证").append(kd.getBNLJKHWHFSR());
                }
                if (kd.getBNLJQTSR().compareTo(hs.getBNLJQTSR()) != 0) {
                    sbDetail.append("|本年累计其他收入不一致, 恒生 ").append(hs.getBNLJQTSR()).append(" 金证").append(kd.getBNLJQTSR());
                }
                if (sbDetail.length() > 0) {
                    System.out.println("产品种类=" + entry.getKey() + "，详情 " + sbDetail.toString());
                } else {
                    okCount++;
                }
            }
        }
        System.out.println("HS总笔数 " + hsMap.size() + " ，核对通过 " + okCount + "笔，不一致 " + (hsMap.size() - okCount) + "笔");
        for (Map.Entry<String, IncomeSum> entry : kdMap.entrySet()) {
            if (hsMap.get(entry.getKey()) == null) {
                System.out.println("IncomeSum, 恒生不存在，金证多，产品种类=" + entry.getKey() + " " + entry.getValue().toString());
            }
        }
    }

    public static Map<String, AckTransSum> readAckSumFile(String filePath) throws IOException {
        Map<String, AckTransSum> ackTransSumMap = new HashMap<>();
        // 读取源代码文件
        // 获得该文件的缓冲输入流
        Path path = Paths.get(filePath);
        try (BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String oneLine = "";
            while ((oneLine = bufferedReader.readLine()) != null) {
                String[] oneLineContent = oneLine.split("\\|");
                String fundcode = oneLineContent[5];
                String invtp = oneLineContent[7];
                String businesscode = oneLineContent[8];

                AckTransSum ack = new AckTransSum();
                /**
                 * 交易笔数	JYBS  10
                 * 交易账户数	JYZHS
                 * 确认份数	QRFS
                 * 确认金额	QRJE
                 * 手续费	SXF
                 * 代理费	DLF
                 */
                ack.setJYBS(Integer.parseInt(oneLineContent[9]));
                ack.setJYZHS(Integer.parseInt(oneLineContent[10]));
                ack.setQRFS(new BigDecimal(oneLineContent[11]));
                ack.setQRJE(new BigDecimal(oneLineContent[12]));
                ack.setSXF(new BigDecimal(oneLineContent[13]));
                ack.setDLF(new BigDecimal(oneLineContent[14]));

                ackTransSumMap.put(fundcode + "_" + invtp + "_" + businesscode, ack);
            }
        }
        return ackTransSumMap;
    }

    public static Map<String, IncomeSum> readIncomeFile(String filePath) throws IOException {
        Map<String, IncomeSum> incomeMap = new HashMap<>();
        // 读取源代码文件
        // 获得该文件的缓冲输入流
        Path path = Paths.get(filePath);
        try (BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String oneLine = "";
            while ((oneLine = bufferedReader.readLine()) != null) {
                String[] str = oneLine.split("\\|");
                String productType = str[5];

                IncomeSum income = new IncomeSum();
                int index = 6;
                income.setBQSR(new BigDecimal(str[index++]));
                income.setBQSXFSR(new BigDecimal(str[index++]));
                income.setBQRGSXFSR(new BigDecimal(str[index++]));
                income.setBQSGSXFSR(new BigDecimal(str[index++]));
                income.setBQSHSXFSR(new BigDecimal(str[index++]));
                income.setBQZHSXFSR(new BigDecimal(str[index++]));
                income.setBQXSFWFSR(new BigDecimal(str[index++]));
                income.setBQKHWHFSR(new BigDecimal(str[index++]));
                income.setBQQTSR(new BigDecimal(str[index++]));
                income.setBNLJSR(new BigDecimal(str[index++]));
                income.setBNLJSXFSR(new BigDecimal(str[index++]));
                income.setBNRGSXFSR(new BigDecimal(str[index++]));
                income.setBNSGSXFSR(new BigDecimal(str[index++]));
                income.setBNSHSXFSR(new BigDecimal(str[index++]));
                income.setBNZHSXFSR(new BigDecimal(str[index++]));
                income.setBNXSFWFSR(new BigDecimal(str[index++]));
                income.setBNLJKHWHFSR(new BigDecimal(str[index++]));
                income.setBNLJQTSR(new BigDecimal(str[index++]));
                incomeMap.put(productType, income);

                System.out.println(productType + " index = " + index);
            }
        }
        return incomeMap;
    }

    public static Map<String, BalFundSum> readBalFundFile(String filePath) throws IOException {
        Map<String, BalFundSum> balFundSumHashMap = new HashMap<>();
        // 读取源代码文件
        // 获得该文件的缓冲输入流
        Path path = Paths.get(filePath);
        try (BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String oneLine = "";
            while ((oneLine = bufferedReader.readLine()) != null) {
                String[] oneLineContent = oneLine.split("\\|");
                String fundcode = oneLineContent[5];
                String invtp = oneLineContent[7];

                BalFundSum bal = new BalFundSum();
                /**
                 * 持有人数	CYRS
                 * 持有份数	CYFS
                 * 持有市值	CYSZ
                 */
                bal.setCYRS(Integer.parseInt(oneLineContent[8]));
                bal.setCYFS(new BigDecimal(oneLineContent[9]));
                bal.setCYSZ(new BigDecimal(oneLineContent[10]));

                balFundSumHashMap.put(fundcode + "_" + invtp, bal);
            }
        }
        return balFundSumHashMap;
    }

}

class IncomeSum {
    /**
     * 本期收入	        BQSR
     * 本期手续费收入	    BQSXFSR
     * 本期认购手续费收入	BQRGSXFSR
     * 本期申购手续费收入	BQSGSXFSR
     * 本期赎回手续费收入	BQSHSXFSR
     * 本期转换手续费收入	BQZHSXFSR
     * 本期销售服务费收入	BQXSFWFSR
     * 本期客户维护费收入	BQKHWHFSR
     * 本期其他收入	    BQQTSR
     * 本年累计收入	    BNLJSR
     * 本年累计手续费收入	BNLJSXFSR
     * 本年认购手续费收入	BNRGSXFSR
     * 本年申购手续费收入	BNSGSXFSR
     * 本年赎回手续费收入	BNSHSXFSR
     * 本年转换手续费收入	BNZHSXFSR
     * 本年销售服务费收入	BNXSFWFSR
     * 本年累计客户维护费收入	BNLJKHWHFSR
     * 本年累计其他收入	BNLJQTSR
     */
    private BigDecimal BQSR;
    private BigDecimal BQSXFSR;
    private BigDecimal BQRGSXFSR;
    private BigDecimal BQSGSXFSR;
    private BigDecimal BQSHSXFSR;
    private BigDecimal BQZHSXFSR;
    private BigDecimal BQXSFWFSR;
    private BigDecimal BQKHWHFSR;
    private BigDecimal BQQTSR;
    private BigDecimal BNLJSR;
    private BigDecimal BNLJSXFSR;
    private BigDecimal BNRGSXFSR;
    private BigDecimal BNSGSXFSR;
    private BigDecimal BNSHSXFSR;
    private BigDecimal BNZHSXFSR;
    private BigDecimal BNXSFWFSR;
    private BigDecimal BNLJKHWHFSR;
    private BigDecimal BNLJQTSR;

    public BigDecimal getBQSR() {
        return BQSR;
    }

    public void setBQSR(BigDecimal BQSR) {
        this.BQSR = BQSR;
    }

    public BigDecimal getBQSXFSR() {
        return BQSXFSR;
    }

    public void setBQSXFSR(BigDecimal BQSXFSR) {
        this.BQSXFSR = BQSXFSR;
    }

    public BigDecimal getBQRGSXFSR() {
        return BQRGSXFSR;
    }

    public void setBQRGSXFSR(BigDecimal BQRGSXFSR) {
        this.BQRGSXFSR = BQRGSXFSR;
    }

    public BigDecimal getBQSGSXFSR() {
        return BQSGSXFSR;
    }

    public void setBQSGSXFSR(BigDecimal BQSGSXFSR) {
        this.BQSGSXFSR = BQSGSXFSR;
    }

    public BigDecimal getBQSHSXFSR() {
        return BQSHSXFSR;
    }

    public void setBQSHSXFSR(BigDecimal BQSHSXFSR) {
        this.BQSHSXFSR = BQSHSXFSR;
    }

    public BigDecimal getBQZHSXFSR() {
        return BQZHSXFSR;
    }

    public void setBQZHSXFSR(BigDecimal BQZHSXFSR) {
        this.BQZHSXFSR = BQZHSXFSR;
    }

    public BigDecimal getBQXSFWFSR() {
        return BQXSFWFSR;
    }

    public void setBQXSFWFSR(BigDecimal BQXSFWFSR) {
        this.BQXSFWFSR = BQXSFWFSR;
    }

    public BigDecimal getBQKHWHFSR() {
        return BQKHWHFSR;
    }

    public void setBQKHWHFSR(BigDecimal BQKHWHFSR) {
        this.BQKHWHFSR = BQKHWHFSR;
    }

    public BigDecimal getBQQTSR() {
        return BQQTSR;
    }

    public void setBQQTSR(BigDecimal BQQTSR) {
        this.BQQTSR = BQQTSR;
    }

    public BigDecimal getBNLJSR() {
        return BNLJSR;
    }

    public void setBNLJSR(BigDecimal BNLJSR) {
        this.BNLJSR = BNLJSR;
    }

    public BigDecimal getBNLJSXFSR() {
        return BNLJSXFSR;
    }

    public void setBNLJSXFSR(BigDecimal BNLJSXFSR) {
        this.BNLJSXFSR = BNLJSXFSR;
    }

    public BigDecimal getBNRGSXFSR() {
        return BNRGSXFSR;
    }

    public void setBNRGSXFSR(BigDecimal BNRGSXFSR) {
        this.BNRGSXFSR = BNRGSXFSR;
    }

    public BigDecimal getBNSGSXFSR() {
        return BNSGSXFSR;
    }

    public void setBNSGSXFSR(BigDecimal BNSGSXFSR) {
        this.BNSGSXFSR = BNSGSXFSR;
    }

    public BigDecimal getBNSHSXFSR() {
        return BNSHSXFSR;
    }

    public void setBNSHSXFSR(BigDecimal BNSHSXFSR) {
        this.BNSHSXFSR = BNSHSXFSR;
    }

    public BigDecimal getBNZHSXFSR() {
        return BNZHSXFSR;
    }

    public void setBNZHSXFSR(BigDecimal BNZHSXFSR) {
        this.BNZHSXFSR = BNZHSXFSR;
    }

    public BigDecimal getBNXSFWFSR() {
        return BNXSFWFSR;
    }

    public void setBNXSFWFSR(BigDecimal BNXSFWFSR) {
        this.BNXSFWFSR = BNXSFWFSR;
    }

    public BigDecimal getBNLJKHWHFSR() {
        return BNLJKHWHFSR;
    }

    public void setBNLJKHWHFSR(BigDecimal BNLJKHWHFSR) {
        this.BNLJKHWHFSR = BNLJKHWHFSR;
    }

    public BigDecimal getBNLJQTSR() {
        return BNLJQTSR;
    }

    public void setBNLJQTSR(BigDecimal BNLJQTSR) {
        this.BNLJQTSR = BNLJQTSR;
    }

    @Override
    public String toString() {
        return "IncomeSum{" +
                "BQSR=" + BQSR +
                ", BQSXFSR=" + BQSXFSR +
                ", BQRGSXFSR=" + BQRGSXFSR +
                ", BQSGSXFSR=" + BQSGSXFSR +
                ", BQSHSXFSR=" + BQSHSXFSR +
                ", BQZHSXFSR=" + BQZHSXFSR +
                ", BQXSFWFSR=" + BQXSFWFSR +
                ", BQKHWHFSR=" + BQKHWHFSR +
                ", BQQTSR=" + BQQTSR +
                ", BNLJSR=" + BNLJSR +
                ", BNLJSXFSR=" + BNLJSXFSR +
                ", BNRGSXFSR=" + BNRGSXFSR +
                ", BNSGSXFSR=" + BNSGSXFSR +
                ", BNSHSXFSR=" + BNSHSXFSR +
                ", BNZHSXFSR=" + BNZHSXFSR +
                ", BNXSFWFSR=" + BNXSFWFSR +
                ", BNLJKHWHFSR=" + BNLJKHWHFSR +
                ", BNLJQTSR=" + BNLJQTSR +
                '}';
    }
}

class BalFundSum {
/**
 * 持有人数	CYRS
 * 持有份数	CYFS
 * 持有市值	CYSZ
 */
    /**
     * 持有人数
     */
    private int CYRS;
    /**
     * 持有份数
     */
    private BigDecimal CYFS;
    /**
     * 持有市值
     */
    private BigDecimal CYSZ;

    public int getCYRS() {
        return CYRS;
    }

    public void setCYRS(int CYRS) {
        this.CYRS = CYRS;
    }

    public BigDecimal getCYFS() {
        return CYFS;
    }

    public void setCYFS(BigDecimal CYFS) {
        this.CYFS = CYFS;
    }

    public BigDecimal getCYSZ() {
        return CYSZ;
    }

    public void setCYSZ(BigDecimal CYSZ) {
        this.CYSZ = CYSZ;
    }

    @Override
    public String toString() {
        return "BalFundSum{" +
                "CYRS=" + CYRS +
                ", CYFS=" + CYFS +
                ", CYSZ=" + CYSZ +
                '}';
    }
}

class AckTransSum {
    private int JYBS;
    private int JYZHS;
    private BigDecimal QRFS;
    private BigDecimal QRJE;
    private BigDecimal SXF;
    private BigDecimal DLF;

    public int getJYBS() {
        return JYBS;
    }

    public void setJYBS(int JYBS) {
        this.JYBS = JYBS;
    }

    public int getJYZHS() {
        return JYZHS;
    }

    public void setJYZHS(int JYZHS) {
        this.JYZHS = JYZHS;
    }

    public BigDecimal getQRFS() {
        return QRFS;
    }

    public void setQRFS(BigDecimal QRFS) {
        this.QRFS = QRFS;
    }

    public BigDecimal getQRJE() {
        return QRJE;
    }

    public void setQRJE(BigDecimal QRJE) {
        this.QRJE = QRJE;
    }

    public BigDecimal getSXF() {
        return SXF;
    }

    public void setSXF(BigDecimal SXF) {
        this.SXF = SXF;
    }

    public BigDecimal getDLF() {
        return DLF;
    }

    public void setDLF(BigDecimal DLF) {
        this.DLF = DLF;
    }

    @Override
    public String toString() {
        return "AckTransSum{" +
                "JYBS=" + JYBS +
                ", JYZHS=" + JYZHS +
                ", QRFS=" + QRFS +
                ", QRJE=" + QRJE +
                ", SXF=" + SXF +
                ", DLF=" + DLF +
                '}';
    }
}
