import java.util.Scanner;

class Visualization {
    private int width;
    private int height;
    private String backgroundColor;
    private boolean isInteractive; // Новое поле

    public Visualization(int width, int height, String backgroundColor, boolean isInteractive) {
        this.width = width;
        this.height = height;
        this.backgroundColor = backgroundColor;
        this.isInteractive = isInteractive;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public boolean isInteractive() {
        return isInteractive;
    }

    public void setInteractive(boolean isInteractive) {
        this.isInteractive = isInteractive;
    }

    public void displayInfo() {
        System.out.println("Визуализация:");
        System.out.println("Ширина: " + width);
        System.out.println("Высота: " + height);
        System.out.println("Цвет заднего фона: " + backgroundColor);
        System.out.println("Интерактивна?: " + isInteractive);
        System.out.println();

    }
}

// Класс VisualizationFrame
class VisualizationFrame {
    private String frameType;
    private boolean isResizable;
    private int zIndex;

    public VisualizationFrame(String frameType, boolean isResizable, int zIndex) {
        this.frameType = frameType;
        this.isResizable = isResizable;
        this.zIndex = zIndex;
    }

    public String getFrameType() {
        return frameType;
    }

    public void setFrameType(String frameType) {
        this.frameType = frameType;
    }

    public boolean isResizable() {
        return isResizable;
    }

    public void setResizable(boolean resizable) {
        isResizable = resizable;
    }

    public int getZIndex() {
        return zIndex;
    }

    public void setZIndex(int zIndex) {
        this.zIndex = zIndex;
    }

    public void increaseZIndex() {
        this.zIndex++;
    }

    public void displayInfo() {
        System.out.println("Фрейм визуализации:");
        System.out.println("Тип фрейма: " + frameType);
        System.out.println("Возможность изменения размера: " + isResizable);
        System.out.println("Z-индекс: " + zIndex);
    }
}

// Класс VisualizationLayer
class VisualizationLayer {
    private String layerName;
    private int opacity;
    private boolean isVisible;

    public VisualizationLayer(String layerName, int opacity, boolean isVisible) {
        this.layerName = layerName;
        this.opacity = opacity;
        this.isVisible = isVisible;
    }

    public String getLayerName() {
        return layerName;
    }

    public void setLayerName(String layerName) {
        this.layerName = layerName;
    }

    public int getOpacity() {
        return opacity;
    }

    public void setOpacity(int opacity) {
        this.opacity = opacity;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public void setVisible(boolean visible) {
        isVisible = visible;
    }

    public void displayInfo() {
        System.out.println("Слой визуализации:");
        System.out.println("Имя слоя: " + layerName);
        System.out.println("Прозрачность: " + opacity);
        System.out.println("Видимый?: " + isVisible);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueInput = true;

        // Создание массивов объектов
        Visualization[] visualizations = new Visualization[3];
        VisualizationFrame[] frames = new VisualizationFrame[3];
        VisualizationLayer[] layers = new VisualizationLayer[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Введите данные для визуализации " + (i + 1) + ":");
            System.out.print("Ширина: ");
            int width = scanner.nextInt();
            System.out.print("Высота: ");
            int height = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Цвет фона: ");
            String backgroundColor = scanner.nextLine();
            System.out.print("Интерактивная визуализация (true/false): ");
            boolean isInteractive = scanner.nextBoolean();

            visualizations[i] = new Visualization(width, height, backgroundColor, isInteractive);

            System.out.println("\nВведите данные для фрейма визуализации " + (i + 1) + ":");
            System.out.print("Разрешение изменения размера (true/false): ");
            boolean isResizable = scanner.nextBoolean();
            scanner.nextLine();
            System.out.print("Тип фрейма: ");
            String frameType = scanner.nextLine();
            System.out.print("Z-индекс: ");
            int zIndex = scanner.nextInt();

            frames[i] = new VisualizationFrame(frameType, isResizable, zIndex);

            System.out.println("\nВведите данные для слоя визуализации " + (i + 1) + ":");
            System.out.print("Имя слоя: ");
            String layerName = scanner.next();
            System.out.print("Прозрачность: ");
            int opacity = scanner.nextInt();
            System.out.print("Видимость (true/false): ");
            boolean isVisible = scanner.nextBoolean();

            layers[i] = new VisualizationLayer(layerName, opacity, isVisible);

            scanner.nextLine();

            System.out.println("");
        }

        // Вывод информации о созданных объектах
        for (int i = 0; i < 3; i++) {
            System.out.println("Информация о визуализации " + (i + 1) + ":");
            visualizations[i].displayInfo();
            System.out.println("Информация о фрейме визуализации " + (i + 1) + ":");
            frames[i].displayInfo();
            System.out.println("Информация о слое визуализации " + (i + 1) + ":");
            layers[i].displayInfo();
        }

        // Поиск наибольшего и наименьшего элемента
        Visualization maxVisualization = visualizations[0];
        Visualization minVisualization = visualizations[0];

        for (Visualization visualization : visualizations) {
            if (visualization.getWidth() > maxVisualization.getWidth()) {
                maxVisualization = visualization;
            }
            if (visualization.getWidth() < minVisualization.getWidth()) {
                minVisualization = visualization;
            }
        }

        System.out.println("Визуализация с наибольшей шириной:");
        maxVisualization.displayInfo();

        System.out.println("Визуализация с наименьшей шириной:");
        minVisualization.displayInfo();

        scanner.close();
    }
}
