package com.pilifenghuolang.ISS;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Integer shopStart=7;
        Integer length=21-8+2;

        Integer[] assNum = {2, 1, 2, 4, 5, 6, 7, 5, 5, 4, 3, 2, 1, 1, 4};
        List<Time> timeList = new ArrayList<>();

        for (int i = 0; i < assNum.length; i++){
            Integer assHave = 0;
            Integer hourStart = i + shopStart;
            int assNeed = assNum[i];//该小时段需要的店员数量
            for (Time time:timeList) {//已经存在的time对当前小时段的和
                if((time.getStartTime() <= hourStart)&&(hourStart + 1 <= time.getEndTime()))
                    assHave++;
            }
            if(assHave < assNeed){
                for (Time time:timeList) {//time能延长的延长一下
                    if(time.getEndTime() - time.getStartTime() < 4 && hourStart == time.getEndTime()){
                        time.setEndTime(time.getEndTime() + 1);
                        assHave++;

                        if(assHave==assNeed) break;//提前延长的够了，就不延长了
                    }
                }
                while(assHave<assNeed){//能延长的都延长了，还不够，需要新的time
                    Time time = new Time(hourStart,hourStart + 2);
                    timeList.add(time);
                    assHave++;
                }
            }

        }

        for(Time time : timeList){
            System.out.println(time);
        }




        /*Time time1 = new Time("9:00","11:00");
        Time time2 = new Time("10:00","12:00");
        Time time3 = new Time("15:00","18:00");
        Time time4 = new Time("15:00","20:00");
        timeManage.add(time1);
        timeManage.add(time2);
        timeManage.add(time3);
        timeManage.add(time4);
        System.out.println(timeManage.get(1));*/
    }
}
