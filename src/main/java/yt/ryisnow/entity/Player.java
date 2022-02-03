package yt.ryisnow.entity;

import java.awt.*;
import java.awt.image.*;

import javax.imageio.ImageIO;

import yt.ryisnow.main.*;

public class Player extends Entity {
    
    GamePanel gamePanel;
    KeyHandler keyHandler;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gamePanel, KeyHandler keyHandler) {
        this.gamePanel = gamePanel;
        this.keyHandler = keyHandler;
        
        screenX = gamePanel.screenWidth / 2 - (gamePanel.tileSize / 2);
        screenY = gamePanel.screenHeight / 2 - (gamePanel.tileSize / 2);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gamePanel.tileSize * 12;
        worldY = gamePanel.tileSize * 12;
        speed = 4;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/res/player/playerUp1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/res/player/playerUp2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/res/player/playerUp3.png"));

            down1 = ImageIO.read(getClass().getResourceAsStream("/res/player/playerDown1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/res/player/playerDown2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/res/player/playerDown3.png"));

            left1 = ImageIO.read(getClass().getResourceAsStream("/res/player/playerLeft1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/res/player/playerLeft2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/res/player/playerLeft3.png"));

            right1 = ImageIO.read(getClass().getResourceAsStream("/res/player/playerRight1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/res/player/playerRight2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/res/player/playerRight3.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void udpate() {
        if (keyHandler.upPressed || keyHandler.downPressed || keyHandler.leftPressed || keyHandler.rightPressed) {
            if (keyHandler.upPressed) { 
                direction = "up";
                worldY -= speed; 
            }
            else if (keyHandler.downPressed) { 
                direction = "down";
                worldY += speed; 
            }
            else if (keyHandler.leftPressed) { 
                direction = "left";
                worldX -= speed; 
            }
            else if (keyHandler.rightPressed) { 
                direction = "right";
                worldX += speed;
            }
    
            spriteCounter++;
            if (spriteCounter > 6) {
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                } else if (spriteNum == 3) {
                    spriteNum = 4;
                } else if (spriteNum == 4) {
                    spriteNum = 1;
                }
    
                spriteCounter = 0;
            }
        } else {
            spriteNum = 2;
        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        switch (direction) {
            case "up":
                if (spriteNum == 1) {
                    image = up1;
                }
                if (spriteNum == 2) {
                    image = up2;
                }
                if (spriteNum == 3) {
                    image = up3;
                }
                if (spriteNum == 4) {
                    image = up2;
                }
                break;
            case "down":
                if (spriteNum == 1) {
                    image = down1;
                }
                if (spriteNum == 2) {
                    image = down2;
                }
                if (spriteNum == 3) {
                    image = down3;
                }
                if (spriteNum == 4) {
                    image = down2;
                }
                break;
            case "left":
                if (spriteNum == 1) {
                    image = left1;
                }
                if (spriteNum == 2) {
                    image = left2;
                }
                if (spriteNum == 3) {
                    image = left3;
                }
                if (spriteNum == 4) {
                    image = left2;
                }
                break;
            case "right":
                if (spriteNum == 1) {
                    image = right1;
                }
                if (spriteNum == 2) {
                    image = right2;
                }
                if (spriteNum == 3) {
                    image = right3;
                }
                if (spriteNum == 4) {
                    image = right2;
                }
                break;
        }

        g2.drawImage(image, screenX, screenY, gamePanel.tileSize, (gamePanel.originalTileSize + 4) * gamePanel.scale, null);
    }

}
