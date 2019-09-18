package ru.j2dev.gameserver.utils;

import ru.j2dev.commons.util.Rnd;

public class CapchaUtil {
    private static final String alphabet = "WJFZNYSGVRU57912";
    private static final int[] crc24tab = {0, 8388707, 8388773, 198, 8388905, 330, 396, 8389103, 8389169, 594, 660, 8389367, 792, 8389499, 8389565, 990, 8389633, 1122, 1188, 8389831, 1320, 8389963, 8390029, 1518, 1584, 8390227, 8390293, 1782, 8390425, 1914, 1980, 8390623, 8390753, 2050, 2244, 8390823, 2376, 8390955, 8391149, 2446, 2640, 8391219, 8391413, 2710, 8391545, 2842, 3036, 8391615, 3168, 8391683, 8391877, 3238, 8392009, 3370, 3564, 8392079, 8392273, 3634, 3828, 8392343, 3960, 8392475, 8392669, 4030, 8392865, 4290, 4100, 8392807, 4488, 8393195, 8393005, 4430, 4752, 8393459, 8393269, 4694, 8393657, 5082, 4892, 8393599, 5280, 8393923, 8393733, 5222, 8394121, 5610, 5420, 8394063, 8394385, 5874, 5684, 8394327, 6072, 8394715, 8394525, 6014, 6336, 8394915, 8394853, 6150, 8395241, 6538, 6476, 8395055, 8395505, 6802, 6740, 8395319, 7128, 8395707, 8395645, 6942, 8395969, 7330, 7268, 8395783, 7656, 8396171, 8396109, 7470, 7920, 8396435, 8396373, 7734, 8396761, 8122, 8060, 8396575, 8397089, 8514, 8580, 8397287, 8200, 8396907, 8396973, 8398, 8976, 8397683, 8397749, 9174, 8397369, 8794, 8860, 8397567, 9504, 8398147, 8398213, 9702, 8397833, 9322, 9388, 8398031, 8398609, 10098, 10164, 8398807, 9784, 8398427, 8398493, 9982, 10560, 8399139, 8399333, 10630, 8398953, 10250, 10444, 8399023, 8399729, 11026, 11220, 8399799, 10840, 8399419, 8399613, 10910, 8400193, 11554, 11748, 8400263, 11368, 8399883, 8400077, 11438, 12144, 8400659, 8400853, 12214, 8400473, 11834, 12028, 8400543, 12672, 8401379, 8401189, 12614, 8401065, 12490, 12300, 8401007, 8401841, 13266, 13076, 8401783, 12952, 8401659, 8401469, 12894, 8402305, 13794, 13604, 8402247, 13480, 8402123, 8401933, 13422, 14256, 8402899, 8402709, 14198, 8402585, 14074, 13884, 8402527, 8403425, 14722, 14660, 8403239, 14536, 8403115, 8403053, 14350, 15312, 8403891, 8403829, 15126, 8403705, 15002, 14940, 8403519, 15840, 8404355, 8404293, 15654, 8404169, 15530, 15468, 8403983, 8404945, 16306, 16244, 8404759, 16120, 8404635, 8404573, 15934};
    private static final long[][][] glyphs = {{{3168L, 891726332900150624L, 963777742074021568L, 0L}, {96L, 27022010087374944L, 27028607257805760L, 0L}, {2016L, 432352161397999552L, 432352161397999104L, 0L}, {2016L, 27022010093666688L, 216179379284215776L, 0L}, {1584L, 445864265978480368L, 463877564951168560L, 0L}, {1632L, 459374171485373376L, 108088040349499776L, 0L}, {960L, 459373759111889280L, 54043607952262080L, 0L}, {960L, 459374171479082496L, 495402968504337376L, 0L}, {1632L, 459374171485374048L, 459374171441332608L, 0L}, {1984L, 459374171485374400L, 486395769249597024L, 0L}, {1632L, 459374171485374048L, 459374171485373376L, 0L}, {2016L, 432352161397999552L, 27022010093668224L, 0L}, {2016L, 27022422410527104L, 108089689642107648L, 0L}, {960L, 459374171485374048L, 279224001555858304L, 0L}, {192L, 126109310794072256L, 54044020174749888L, 0L}, {960L, 459374171384709312L, 108089689692440544L, 0L}}, {{1636196742L, 7027413971481932748L, 3921569213490666552L, 2033375231757778944L}, {66060336L, 13511005043687472L, 13511005043687520L, 558446353793941504L}, {133694976L, 432352161397999608L, 432352161397999104L, 432345564227567616L}, {267386928L, 27022422410527104L, 216176080749333504L, 1148417904979476480L}, {402922500L, 2162879027319411140L, 1217115889971499036L, 1156299204327374848L}, {404232216L, 878215327742165952L, 270217626934837632L, 108086391056891904L}, {66061848L, 871459722295773168L, 33777100487396400L, 567453553048682496L}, {66063896L, 871472916577917176L, 1736164147912511000L, 283726776524341248L}, {405805104L, 1742906662456396896L, 486396181572748160L, 252201579132747776L}, {266341424L, 878215327839685728L, 1134920712758234136L, 868068828175663104L}, {404232216L, 1736164148113840152L, 1736164148113837104L, 567453553048682496L}, {133694976L, 432352161429454896L, 6755502723173424L, 567453553048682496L}, {267911216L, 13511211205263552L, 54044844821054208L, 216172782113783808L}, {65013296L, 871459825317840408L, 285978679420387424L, 558446353793941504L}, {25167744L, 108088040349499776L, 108088040349499776L, 567453553048682496L}, {132123696L, 871446630976978992L, 27023521959904768L, 1150669704793161728L}}, {{12684L, 3570283082392542168L, 1898283117340265520L, 0L}, {992L, 27022010087374944L, 27022010087376832L, 0L}, {2016L, 432352161397999552L, 432352161397999104L, 0L}, {2016L, 54044020187332992L, 216176080749332448L, 0L}, {3088L, 1013322079691344272L, 635017237047019568L, 0L}, {3120L, 878208936786788736L, 108088040349499776L, 0L}, {1984L, 873711522084292544L, 63050807240558528L, 0L}, {992L, 436862358195801088L, 932258523267466224L, 0L}, {3168L, 891726332788999872L, 486392608105431936L, 0L}, {4032L, 891726332883374016L, 972791538492902448L, 0L}, {3120L, 878215327839685680L, 878215327839684576L, 0L}, {2016L, 432352161427357792L, 27022010288703424L, 0L}, {2032L, 13511211205263552L, 54044844821054208L, 0L}, {1984L, 891726332883373152L, 567453965378127744L, 0L}, {384L, 540433604577067392L, 108088040349501408L, 0L}, {992L, 445856569271255136L, 54044844846221296L, 0L}}, {{2056L, 578723066359581472L, 1387132050212919680L, 1224979098644774912L}, {480L, 9007336697888832L, 18014948273684736L, 2161727821137838080L}, {1020L, 144117387166221312L, 567462349275924480L, 1152921504606846976L}, {1020L, 2251868535259200L, 36032095620958208L, 2296835809958952960L}, {776L, 218427914907026576L, 328772256230541472L, 1170935903116328960L}, {2064L, 585477022604592384L, 432349962341188608L, 576460752303423488L}, {496L, 148620986776813952L, 54043470410549312L, 1116892707587883008L}, {248L, 218428980108199936L, 608003679724768288L, 558446353793941504L}, {2056L, 580973216812500032L, 324265220568516096L, 288230376151711744L}, {496L, 78814127384953376L, 270220925515859040L, 585467951558164480L}, {520L, 146369221340693520L, 292742909447374912L, 540431955284459520L}, {16253184L, 72058693608276032L, 18014673391583360L, 1080863910568919040L}, {66584592L, 9007474141036800L, 144119586189477888L, 1152921504606846976L}, {15728920L, 150872855327802928L, 279223314340120704L, 1080863910568919040L}, {68722622944L, 9007336697888832L, 18014948273684608L, 1143914305352105984L}, {15728904L, 2251834174472224L, 18016047810479104L, 1134907106097364992L}}};

    public static int buildCapcha(final short text, final byte font) {
        return (text | font << 16) & 0xFFFFFF;
    }

    public static short getCapchaTextPart(final int capcha) {
        return (short) (capcha & 0xFFFF);
    }

    public static byte getCapchaFontPart(final int capcha) {
        return (byte) (capcha >> 16 & 0xFF);
    }

    public static short rgb888TOrgb565(final int rgb888) {
        return (short) (((rgb888 >> 8 & 0xF808) | (rgb888 >> 5 & 0x7E0) | (rgb888 >> 3 & 0x1F)) & 0xFFFF);
    }

    public static String getCapchaText(final int capcha) {
        final char[] r = new char[4];
        final short text = getCapchaTextPart(capcha);
        for (int i = 0; i < 4; ++i) {
            r[i] = alphabet.charAt(text >> (i << 2) & 0xF);
        }
        return new String(r);
    }

    public static byte[] getCapchaImage(final int capcha, final int bgcolor) {
        final byte[] r = new byte[640];
        final short text = getCapchaTextPart(capcha);
        final byte font = getCapchaFontPart(capcha);
        long m;
        final short bgc = rgb888TOrgb565(bgcolor);
        final short c = (short) ~bgc;
        r[1] = (r[0] = 68);
        r[2] = 83;
        r[3] = 32;
        r[4] = 124;
        r[8] = 7;
        r[9] = 16;
        r[10] = 8;
        r[12] = 16;
        r[16] = 64;
        r[21] = 2;
        r[76] = 32;
        r[80] = 4;
        r[84] = 68;
        r[85] = 88;
        r[86] = 84;
        r[87] = 49;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 4; ++j) {
                m = glyphs[font >> (j << 1) & 0x3][text >> (j << 2) & 0xF][i];
                final int k = 128 + (j << 5) + (i << 7);
                r[k] = (byte) (bgc & 0xFF);
                r[k + 1] = (byte) (bgc >> 8 & 0xFF);
                r[k + 2] = (byte) (c & 0xFF);
                r[k + 3] = (byte) (c >> 8 & 0xFF);
                r[k + 4] = (byte) ((m >> 63 & 0x1L) | (m >> 60 & 0x4L) | (m >> 57 & 0x10L) | (m >> 54 & 0x40L));
                r[k + 5] = (byte) ((m >> 47 & 0x1L) | (m >> 44 & 0x4L) | (m >> 41 & 0x10L) | (m >> 38 & 0x40L));
                r[k + 6] = (byte) ((m >> 31 & 0x1L) | (m >> 28 & 0x4L) | (m >> 25 & 0x10L) | (m >> 22 & 0x40L));
                r[k + 7] = (byte) ((m >> 15 & 0x1L) | (m >> 12 & 0x4L) | (m >> 9 & 0x10L) | (m >> 6 & 0x40L));
                r[k + 8] = (byte) (bgc & 0xFF);
                r[k + 9] = (byte) (bgc >> 8 & 0xFF);
                r[k + 10] = (byte) (c & 0xFF);
                r[k + 11] = (byte) (c >> 8 & 0xFF);
                r[k + 12] = (byte) ((m >> 59 & 0x1L) | (m >> 56 & 0x4L) | (m >> 53 & 0x10L) | (m >> 50 & 0x40L));
                r[k + 13] = (byte) ((m >> 43 & 0x1L) | (m >> 40 & 0x4L) | (m >> 37 & 0x10L) | (m >> 34 & 0x40L));
                r[k + 14] = (byte) ((m >> 27 & 0x1L) | (m >> 24 & 0x4L) | (m >> 21 & 0x10L) | (m >> 18 & 0x40L));
                r[k + 15] = (byte) ((m >> 11 & 0x1L) | (m >> 8 & 0x4L) | (m >> 5 & 0x10L) | (m >> 2 & 0x40L));
                r[k + 16] = (byte) (bgc & 0xFF);
                r[k + 17] = (byte) (bgc >> 8 & 0xFF);
                r[k + 18] = (byte) (c & 0xFF);
                r[k + 19] = (byte) (c >> 8 & 0xFF);
                r[k + 20] = (byte) ((m >> 55 & 0x1L) | (m >> 52 & 0x4L) | (m >> 49 & 0x10L) | (m >> 46 & 0x40L));
                r[k + 21] = (byte) ((m >> 39 & 0x1L) | (m >> 36 & 0x4L) | (m >> 33 & 0x10L) | (m >> 30 & 0x40L));
                r[k + 22] = (byte) ((m >> 23 & 0x1L) | (m >> 20 & 0x4L) | (m >> 17 & 0x10L) | (m >> 14 & 0x40L));
                r[k + 23] = (byte) ((m >> 7 & 0x1L) | (m >> 4 & 0x4L) | (m >> 1 & 0x10L) | (m << 2 & 0x40L));
                r[k + 24] = (byte) (bgc & 0xFF);
                r[k + 25] = (byte) (bgc >> 8 & 0xFF);
                r[k + 26] = (byte) (c & 0xFF);
                r[k + 27] = (byte) (c >> 8 & 0xFF);
                r[k + 28] = (byte) ((m >> 51 & 0x1L) | (m >> 48 & 0x4L) | (m >> 45 & 0x10L) | (m >> 42 & 0x40L));
                r[k + 29] = (byte) ((m >> 35 & 0x1L) | (m >> 32 & 0x4L) | (m >> 29 & 0x10L) | (m >> 26 & 0x40L));
                r[k + 30] = (byte) ((m >> 19 & 0x1L) | (m >> 16 & 0x4L) | (m >> 13 & 0x10L) | (m >> 10 & 0x40L));
                r[k + 31] = (byte) ((m >> 3 & 0x1L) | (m & 0x4L) | (m << 3 & 0x10L) | (m << 6 & 0x40L));
            }
        }
        return r;
    }

    public static int getId(final int capcha) {
        final short text = getCapchaTextPart(capcha);
        final byte font = getCapchaFontPart(capcha);
        int r = 11994318;
        r = (r << 8 ^ crc24tab[(r >>> 16 ^ (text >> 8 & 0xFF)) & 0xFF]);
        r = (r << 8 ^ crc24tab[(r >>> 16 ^ (text & 0xFF)) & 0xFF]);
        r = (r << 8 ^ crc24tab[(r >>> 16 ^ font) & 0xFF]);
        return r & 0xFFFFFF;
    }

    public static int RndCapcha() {
        return buildCapcha((short) Rnd.get(65535), (byte) Rnd.get(255));
    }

    public static int RndRGB888Color() {
        int r = Rnd.get(255);
        int g = Rnd.get(255);
        int b = Rnd.get(255);
        if (r >= 122 && r <= 134 && g >= 122 && g <= 134 && b >= 122 && b <= 134) {
            r = 0;
            g = 0;
            b = 0;
        }
        return (0xFFFFFF & (r << 16 & 0xFF0000)) | (g << 8 & 0xFF00) | (b & 0xFF);
    }

    public static boolean IsValidEntry(final int capcha, final String entry) {
        return entry.trim().toUpperCase().equalsIgnoreCase(getCapchaText(capcha));
    }
}