package com.wang.learning;

public class QPractice {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length<=0||matrix[0].length<=0){
            return false;
        }
        boolean[][] visit=new boolean[matrix.length][matrix[0].length];
        return dfs(matrix,visit,0,0,target);
    }

    private boolean dfs(int[][] matrix,boolean[][] visit,int x,int y,int target){
        if(x>=matrix.length||y>=matrix[0].length||visit[x][y]){
            return false;
        }
        if(matrix[x][y]==target){
            return true;
        }
        visit[x][y]=true;
        return dfs(matrix,visit,x+1,y,target)||dfs(matrix,visit,x,y+1,target);
    }

    public static void main(String[] args) {
        String str="################################################################注释代码\n" +
                ":<<EOF\n" +
                "名称 ：visit_record\n" +
                "功能描述 ：从visit_record导入到visit_record\n" +
                "输入表 ：HtlInfoGovernDB.visit_record\n" +
                "输出表 ：ods_htl_HtlInfoGovernDB.visit_record\n" +
                "需求方：nzhong\n" +
                "创建时间：2020-12-02\n" +
                "运行类型 ： \n" +
                "注意事项 ：\n" +
                "说明 ：\n" +
                "修改历史 ：修改人    / 修改时间  / 主要改动说明\n" +
                "EOF\n" +
                "#################################################################注释代码\n" +
                "\n" +
                "set -eu\n" +
                "pre_days_value=${zdt.addDay(-3).format(\"yyyy-MM-dd\")} \n" +
                "\n" +
                "\n" +
                "sh datax_run.sh \\\n" +
                "  -src mysqldal \\\n" +
                "  -srcallinone HtlInfoGovernDB_ETLZS_SH \\\n" +
                "  -srcdb HtlInfoGovernDB \\\n" +
                "  -srctblnames visit_record \\\n" +
                "  -querys \"select id,planid,hotelid,visit_date,goal_reach,feedback,note,call_time,geo,images,type,create_time,creator,datachange_lasttime,is_deleted,goals,soundUrl,due_start_date,due_end_date,commonView,notifyHotel,areaIds,taskGoals from visit_record\n" +
                " -- where DataChange_LastTime >= '${pre_days_value}'\" \\\n" +
                "  -pks id \\\n" +
                "  -tar hdfs \\\n" +
                "  -tardb ods_htl_HtlInfoGovernDB \\\n" +
                "  -tartblnames visit_record \\\n" +
                "  -loadtype 2";

        String str_temp=str.replace("-loadtype 2","-loadtype 7");
        System.out.println(str_temp);
    }

}



