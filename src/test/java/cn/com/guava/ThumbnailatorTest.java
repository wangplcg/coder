package cn.com.guava;

import gov.etax.dzswj.commons.dto.ResultDto;
import net.coobird.thumbnailator.Thumbnails;
import org.junit.Test;
import org.springframework.util.Base64Utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Description:
 * User: wangpl
 * Date: 2019-07-08
 * Time: 11:30
 */

public class ThumbnailatorTest {

    @Test
    public void compressImage() {
        String a = "123";
        while(Base64Utils.decodeFromString(a).length > 30 * 1024) {
            byte[] imgBytes = Base64Utils.decodeFromString(a);
            byte[] tempByte = new byte[imgBytes.length];
            ByteArrayInputStream intputStream = new ByteArrayInputStream(tempByte);
            Thumbnails.Builder<? extends InputStream> builder = Thumbnails.of(intputStream).scale(0.1f).outputQuality(0.5f);
            try {
                System.out.println("压缩 before " + imgBytes.length);

                BufferedImage bufferedImage = builder.asBufferedImage();
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "png", baos);
                imgBytes = baos.toByteArray();
                a = Base64Utils.encodeToString(imgBytes);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    intputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(a);
    }
}
