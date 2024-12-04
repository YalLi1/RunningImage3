import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class RunningImage extends JPanel {
    private BufferedImage logo;
    private int xPosition = 100; // Начальная позиция по оси X
    private int yPosition = 100; // Начальная позиция по оси Y
    private int xSpeed = 5; // Скорость перемещения по оси X
    private int ySpeed = 5; // Скорость перемещения по оси Y

    public RunningImage() {
        // Загружаем изображение
        try {
            logo = ImageIO.read(new File("C:\\Users\\New\\Pictures\\1.jpg")); // Укажите свой путь к изображению
        } catch (IOException e) {
            System.out.println(e);
        }

        // Генерируем случайные скорости в диапазоне от 1 до 10
        xSpeed = (int) (Math.random() * 10 + 1);
        ySpeed = (int) (Math.random() * 10 + 1);

        // Создаем таймер для обновления позиции логотипа
        Timer timer = new Timer(30, e -> moveLogo());
        timer.start();
    }

    private void moveLogo() {
        // Обновляем позицию логотипа
        xPosition += xSpeed;
        yPosition += ySpeed;

        // Проверяем границы и изменяем направление
        if (xPosition + logo.getWidth() >= getWidth() || xPosition < 0) {
            xSpeed = -xSpeed; // Меняем направление по оси X
        }
        if (yPosition + logo.getHeight() >= getHeight() || yPosition < 0) {
            ySpeed = -ySpeed; // Меняем направление по оси Y
        }

        repaint(); // Перерисовываем панель
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Рисуем логотип DVD
        if (logo != null) {
            g.drawImage(logo, xPosition, yPosition, null);
        }
    }
}
