package com.myobit.util;

/**
 * Created by Phillip on 5/21/2016.
 */
public class LocationUtils {

    public enum States{
        Alabama                     ("01","AL"),
        Alaska                      ("02","AK"),
        Arizona                     ("04","AZ"),
        Arkansas                    ("05","AR"),
        California                  ("06","CA"),
        Colorado                    ("08","CO"),
        Connecticut                 ("09","CT"),
        Delaware                    ("10","DE"),
        District_of_Columbia        ("11","DC"),
        Florida                     ("12","FL"),
        Georgia                     ("13","GA"),
        Hawaii                      ("15","HI"),
        Idaho                       ("16","ID"),
        Illinois                    ("17","IL"),
        Indiana                     ("18","IN"),
        Iowa                        ("19","IA"),
        Kansas                      ("20","KS"),
        Kentucky                    ("21","KY"),
        Louisiana                   ("22","LA"),
        Maine                       ("23","ME"),
        Maryland                    ("24","MD"),
        Massachusetts               ("25","MA"),
        Michigan                    ("26","MI"),
        Minnesota                   ("27","MN"),
        Mississippi                 ("28","MS"),
        Missouri                    ("29","MO"),
        Montana                     ("30","MT"),
        Nebraska                    ("31","NE"),
        Nevada                      ("32","NV"),
        New_Hampshire               ("33","NH"),
        New_Jersey                  ("34","NJ"),
        New_Mexico                  ("35","NM"),
        New_York                    ("36","NY"),
        North_Carolina              ("37","NC"),
        North_Dakota                ("38","ND"),
        Ohio                        ("39","OH"),
        Oklahoma                    ("40","OK"),
        Oregon                      ("41","OR"),
        Pennsylvania                ("42","PA"),
        Rhode_Island                ("44","RI"),
        South_Carolina              ("45","SC"),
        South_Dakota                ("46","SD"),
        Tennessee                   ("47","TN"),
        Texas                       ("48","TX"),
        Utah                        ("49","UT"),
        Vermont                     ("50","VT"),
        Virginia                    ("51","VA"),
        Washington                  ("53","WA"),
        West_Virginia               ("54","WV"),
        Wisconsin                   ("55","WI"),
        Wyoming                     ("56","WY");

        private final String fipsCode;
        private final String uspsCode;

        States(String fipsCode, String uspsCode) {
            this.fipsCode = fipsCode;
            this.uspsCode = uspsCode;
        }

        public String getFipsCode() {
            return fipsCode;
        }

        public String getUspsCode() {
            return uspsCode;
        }
    }
}
