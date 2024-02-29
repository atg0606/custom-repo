package org.privaterepo.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Member {


    JUNGWON("M0000010716380", "N09IeGVOb1JxQVlyVU0zRGN1YmJFQT09"),
    TAEGEON("M0000019859066", "WFowVmdjVWZlUGc5VFc3UWgzaGFVUT09"),
    BORA("M0000004709880", "R2psS1VueVo2Mzd4OW04Yll0bXhiUT09"),
    YEEUN("M0000000199508", "MlV1RmMrNEcyc2owRmJ2SzYvQUEyQT09"),
    JONGHYUN("M0000016349716", "YStHMGZFV0dvOXo1Mk1RT0hUL0w5dz09"),
    HYUNHO("M0000010147999", "VkFBSTRtODRJS2R4ZzRxMDV0bVByUT09"),
    HYUNJUN("M0000016077177", "NDg3WGZSdUdlblBpeEFIY3RRSVF3dz09");

    private final String memberNumber;
    private final String profileKey;

}
