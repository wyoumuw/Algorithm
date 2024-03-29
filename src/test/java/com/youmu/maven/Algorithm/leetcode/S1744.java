package com.youmu.maven.Algorithm.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class S1744 {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] sums = new long[candiesCount.length];
        sums[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            sums[i] = candiesCount[i] + sums[i - 1];
        }
        boolean[] result = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            result[i] = canEat(sums, query[0], query[1] + 1, query[2]);
        }
        return result;
    }

    boolean canEat(long[] candiesCount, int favoriteType, int favoriteDay, int dailyCap) {
        long start = (favoriteType == 0 ? 0 : candiesCount[favoriteType - 1]);
        long end = candiesCount[favoriteType];
        long max = ((long) dailyCap) * favoriteDay;
        return !(start >= max || end < favoriteDay);
    }


    @Test
    public void Test2() throws Exception {
        int[] candiesCount = {7, 4, 5, 3, 8};
        int[][] queries = {{0, 2, 2}, {4, 2, 4}, {2, 13, 1000000000}};
        boolean[] booleans = canEat(candiesCount, queries);
        for (boolean aBoolean : booleans) {
            System.out.println(aBoolean);
        }
    }

    @Test
    public void Test() throws Exception {
        int[] candiesCount = {5, 2, 6, 4, 1};
        int[][] queries = {{3, 1, 2}, {4, 10, 3}, {3, 10, 100}, {4, 100, 30}, {1, 3, 1}};
        boolean[] booleans = canEat(candiesCount, queries);
        for (boolean aBoolean : booleans) {
            System.out.println(aBoolean);
        }
    }

    @Test
    public void Test4() throws Exception {
        int[] candiesCount = {46, 5, 47, 48, 43, 34, 15, 26, 11, 25, 41, 47, 15, 25, 16, 50, 32, 42, 32, 21, 36, 34, 50, 45, 46, 15, 46, 38, 50, 12, 3, 26, 26, 16, 23, 1, 4, 48, 47, 32, 47, 16, 33, 23, 38, 2, 19, 50, 6, 19, 29, 3, 27, 12, 6, 22, 33, 28, 7, 10, 12, 8, 13, 24, 21, 38, 43, 26, 35, 18, 34, 3, 14, 48, 50, 34, 38, 4, 50, 26, 5, 35, 11, 2, 35, 9, 11, 31, 36, 20, 21, 37, 18, 34, 34, 10, 21, 8, 5};
        int[][] queries = {{80, 2329, 69}, {14, 1485, 76}, {33, 2057, 83}, {13, 1972, 27}, {11, 387, 25}, {24, 1460, 47}, {22, 1783, 35}, {1, 513, 33}, {66, 2124, 85}, {19, 642, 26}, {15, 1963, 79}, {93, 722, 96}, {15, 376, 88}, {60, 1864, 89}, {86, 608, 4}, {98, 257, 35}, {35, 651, 47}, {96, 795, 73}, {62, 2077, 18}, {27, 1724, 57}, {34, 1984, 75}, {49, 2413, 95}, {76, 1664, 5}, {28, 38, 13}, {85, 54, 42}, {12, 301, 3}, {62, 2016, 29}, {45, 2316, 37}, {43, 2360, 28}, {87, 192, 98}, {27, 2082, 21}, {74, 762, 37}, {51, 35, 17}, {73, 2193, 4}, {60, 425, 65}, {11, 1522, 58}, {21, 1699, 66}, {42, 1473, 5}, {30, 2010, 48}, {91, 796, 74}, {82, 2162, 31}, {23, 2569, 65}, {24, 684, 23}, {70, 1219, 51}, {5, 1817, 15}, {81, 2446, 34}, {96, 771, 60}, {49, 1171, 60}, {41, 567, 67}, {39, 799, 59}, {90, 957, 81}, {84, 2122, 27}, {82, 1707, 44}, {11, 1889, 20}, {80, 1697, 83}, {24, 1786, 60}, {90, 1847, 99}, {51, 114, 21}, {44, 466, 85}, {56, 469, 20}, {44, 350, 96}, {66, 1946, 10}, {14, 2470, 12}, {69, 1175, 18}, {98, 1804, 25}, {77, 2187, 40}, {89, 2265, 45}, {19, 2246, 45}, {40, 2373, 79}, {60, 2222, 17}, {37, 385, 5}, {97, 1759, 97}, {10, 903, 5}, {87, 842, 45}, {74, 2398, 66}, {62, 49, 94}, {48, 156, 77}, {76, 2310, 80}, {64, 2360, 95}, {70, 1699, 83}, {39, 1241, 66}, {92, 2312, 21}, {63, 2148, 29}, {95, 594, 74}, {89, 90, 51}, {82, 137, 70}, {54, 301, 97}, {15, 819, 43}, {47, 1402, 60}, {17, 2377, 43}, {50, 1937, 95}, {62, 1174, 74}, {67, 1411, 87}, {39, 1151, 48}};
        Boolean[] expects = {false, false, false, false, true, false, false, false, false, false, false, true, true, false, true, true, true, true, false, false, false, false, true, false, true, true, false, false, false, true, false, true, false, false, true, false, false, false, false, true, true, false, true, true, false, false, true, true, true, true, true, true, true, false, true, false, true, true, true, true, true, false, false, true, true, false, true, false, false, false, true, true, false, true, false, true, true, false, false, true, false, true, false, true, true, true, true, false, true, false, false, true, true, true};
        boolean[] booleans = canEat(candiesCount, queries);
        Assert.assertArrayEquals(expects, cvt(booleans));
    }

    @Test
    public void Test5() throws Exception {
        int[] candiesCount = {5215, 14414, 67303, 93431, 44959, 34974, 22935, 64205, 28863, 3436, 45640, 34940, 38519, 5705, 14594, 30510, 4418, 87954, 8423, 65872, 79062, 83736, 47851, 64523, 15639, 19173, 88996, 97578, 1106, 17767, 63298, 8620, 67281, 76666, 50386, 97303, 26476, 95239, 21967, 31606, 3943, 33752, 29634, 35981, 42216, 88584, 2774, 3839, 81067, 59193, 225, 8289, 9295, 9268, 4762, 2276, 7641, 3542, 3415, 1372, 5538, 878, 5051, 7631, 1394, 5372, 2384, 2050, 6766, 3616, 7181, 7605, 3718, 8498, 7065, 1369, 1967, 2781, 7598, 6562, 7150, 8132, 1276, 6656, 1868, 8584, 9442, 8762, 6210, 6963, 4068, 1605, 2780, 556, 6825, 4961, 4041, 4923, 8660, 4114};
        int[][] queries = {{46, 4191056, 444472063}, {75, 865431, 146060662}, {91, 244597, 840227137}, {89, 2601754, 901415801}, {69, 1777314, 444098682}, {78, 2957259, 231019870}, {19, 4350225, 516815116}, {42, 4081198, 594990005}, {59, 3176552, 508520222}, {77, 4577766, 38900694}, {92, 320256, 1362}, {44, 3992014, 7209}, {55, 1950613, 1370}, {97, 734069, 3066}, {39, 1188632, 661}, {58, 4526426, 6202}, {51, 3083812, 1767}, {46, 2563654, 9680}, {21, 4012578, 7014}, {66, 2185952, 7039}, {67, 3712445, 1239}, {0, 1840130, 185}, {35, 605159, 7105}, {94, 2269908, 416}, {68, 4117247, 2076}, {0, 4540381, 2412}, {20, 579583, 8917}, {62, 4407388, 7127}, {17, 4468545, 6287}, {50, 3462654, 1410}, {7, 1883037, 77}, {4, 4089924, 5849}, {5, 4340465, 3843}, {68, 596099, 5796}, {29, 542371, 5952}, {91, 441898, 2227}, {35, 912775, 6110}, {12, 267236, 3248}, {27, 990261, 771}, {76, 320119, 5220}, {23, 738123, 2504}, {66, 439801, 4436}, {18, 372357, 1654}, {51, 846227, 5325}, {80, 502088, 3751}, {49, 117408, 102}, {75, 837527, 8747}, {46, 984134, 7924}, {42, 463312, 7558}, {50, 214995, 1043}, {94, 981465, 6758}, {79, 892988, 1063}, {17, 985872, 2314}, {71, 870151, 2004}, {63, 793308, 7608}, {49, 873121, 2846}, {32, 453564, 3739}, {42, 890492, 6026}, {19, 278107, 2649}, {64, 792101, 2208}, {98, 577463, 526}, {41, 572006, 748}, {99, 478120, 895}, {52, 224338, 423}, {83, 532978, 600}, {67, 92281, 486}, {28, 829955, 925}, {22, 171381, 749}, {82, 986821, 603}, {57, 294692, 194}, {9, 730892, 973}, {69, 241093, 931}, {70, 646855, 27}, {45, 233480, 669}, {60, 369922, 965}, {27, 935011, 659}, {96, 667580, 837}, {7, 919344, 188}, {99, 584762, 131}, {5, 93173, 898}, {16, 736395, 184}, {57, 893061, 196}, {28, 352640, 924}, {87, 980414, 80}, {88, 432895, 129}, {23, 461032, 85}, {73, 645991, 268}, {5, 241036, 458}, {9, 422324, 785}, {28, 124913, 224}, {51, 815633, 765}, {59, 894120, 559}, {70, 459876, 192}, {80, 423125, 584}, {85, 824496, 142}, {18, 578975, 104}, {56, 477816, 303}, {6, 702127, 400}, {43, 35371, 850}, {3, 226423, 10}};
        Boolean[] expects = {false, true, true, false, true, false, false, false, false, false, true, false, true, true, true, false, false, false, false, true, false, false, true, true, false, false, true, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, true, true, true, true, false, true, true, false, true, true, true, true, true, true, true, false, true, true, true, true, true, true, true, true, false, true, false};
        boolean[] booleans = canEat(candiesCount, queries);
        Assert.assertArrayEquals(expects, cvt(booleans));
    }

    @Test
    public void Test3() throws Exception {
        int[] candiesCount = {16, 38, 8, 41, 30, 31, 14, 45, 3, 2, 24, 23, 38, 30, 31, 17, 35, 4, 9, 42, 28, 18, 37, 18, 14, 46, 11, 13, 19, 3, 5, 39, 24, 48, 20, 29, 4, 19, 36, 11, 28, 49, 38, 16, 23, 24, 4, 22, 29, 35, 45, 38, 37, 40, 2, 37, 8, 41, 33, 8, 40, 27, 13, 4, 33, 5, 8, 14, 19, 35, 31, 8, 8};
        int[][] queries = {{35, 669, 5}, {72, 822, 74}, {47, 933, 94}, {62, 942, 85}, {42, 596, 11}, {56, 1066, 18}, {54, 571, 45}, {39, 890, 100}, {3, 175, 26}, {48, 1489, 37}, {40, 447, 52}, {30, 584, 7}, {26, 1486, 38}, {21, 1142, 21}, {9, 494, 96}, {56, 759, 81}, {13, 319, 16}, {20, 1406, 57}, {11, 1092, 19}, {24, 670, 67}, {38, 1702, 33}, {5, 676, 32}, {50, 1386, 77}, {36, 1551, 87}, {29, 1445, 13}, {58, 977, 13}, {7, 887, 64}, {37, 1396, 23}, {0, 765, 69}, {40, 1083, 86}, {43, 1054, 49}, {48, 690, 92}, {28, 1201, 56}, {47, 948, 43}, {57, 233, 25}, {32, 1293, 65}, {0, 1646, 34}, {43, 1467, 39}, {39, 484, 23}, {21, 1576, 69}, {12, 1222, 68}, {9, 457, 83}, {32, 65, 9}, {10, 1424, 42}, {35, 534, 3}, {23, 83, 22}, {33, 501, 33}, {25, 679, 51}, {2, 321, 42}, {1, 240, 68}, {7, 1297, 42}, {45, 480, 72}, {26, 1472, 9}, {6, 649, 90}, {26, 361, 57}, {49, 1592, 7}, {11, 158, 95}, {35, 448, 24}, {41, 1654, 10}, {61, 510, 43}, {31, 1230, 95}, {11, 1471, 12}, {37, 43, 84}, {56, 1147, 48}, {69, 1368, 65}, {22, 170, 24}, {56, 192, 80}, {34, 1207, 69}, {1, 1226, 22}, {37, 1633, 50}, {11, 98, 58}, {17, 125, 13}, {0, 1490, 5}, {37, 1732, 43}, {45, 793, 14}, {16, 578, 72}, {50, 241, 78}};
        Boolean[] expects = {true, true, true, true, true, true, true, true, false, false, true, true, false, false, false, true, true, false, false, false, false, false, false, false, false, true, false, false, false, false, false, true, false, true, true, false, false, false, true, false, false, false, false, false, true, true, true, false, false, false, false, true, false, false, true, false, true, true, false, true, false, false, true, true, true, true, true, false, false, false, true, true, false, false, true, false, true};
        boolean[] booleans = canEat(candiesCount, queries);
        Assert.assertArrayEquals(expects, cvt(booleans));
    }

    private Boolean[] cvt(boolean[] a) {
        Boolean[] re = new Boolean[a.length];
        for (int i = 0; i < a.length; i++) {
            re[i] = a[i];
        }
        return re;
    }
}
