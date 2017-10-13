package test.selfTest;

import utility.tools.WeekDay;

public class TestEnum {
	public static void main(String args[]) {
        for (WeekDay day : WeekDay.values()) {
            System.out.println(day + "====>" + day.getDay());
        }
        WeekDay.printDay(5);
    }
}
