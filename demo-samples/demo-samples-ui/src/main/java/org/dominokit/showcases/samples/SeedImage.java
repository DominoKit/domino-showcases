package org.dominokit.showcases.samples;

import org.gwtproject.i18n.client.NumberFormat;

public class SeedImage {
    private static int SEED = 0;

    public static String seedNext() {
        return "https://picsum.photos/seed/"+ NumberFormat.getFormat("0000").format(SEED++) +"/64/64";
    }

}
