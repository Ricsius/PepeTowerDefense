/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package pepetd1.pkg0;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author Hege
 */
public class AnimationHandler {
    BufferedImage fullImage;
    int animationIndex;
    int frameIndex;
    int frameWidth;
    int frameHeight;

    public AnimationHandler(String imagePath, int frameWidth, int frameHeight) throws IOException {
        this.fullImage = ImageIO.read(new File(imagePath));
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        this.animationIndex = 0;
        this.frameIndex = 0;
    }

    public void nextFrame() {
        if((frameIndex + 1) * frameWidth >= this.fullImage.getWidth()) {
            this.frameIndex = 0;
        }
        else {
            ++frameIndex;
        }
    }

    public void setAnimationIndex(int i) throws IllegalArgumentException{
        if(i * frameHeight > this.fullImage.getHeight()) {
            throw  new IllegalArgumentException();
        }
        else {
            this.animationIndex = i;
            this.frameIndex = 0;
        }
    }

    public Image getCurrentFrame() {
        return this.fullImage.getSubimage(this.frameIndex*this.frameWidth,
                this.animationIndex*this.frameHeight,
                this.frameWidth,
                this.frameHeight);
    }
}
