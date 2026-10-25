package ru.aston.homework3.proxy;

public class RealDashboardDisplay implements DashboardDisplay {
    private String modelName;
    public RealDashboardDisplay(String modelName) {
        this.modelName = modelName;
        loadHeavy3DTextures();
    }
    private void loadHeavy3DTextures() { System.out.println("[Загрузка тяжелых 3D текстур салона автомобиля " + modelName + "...]"); }
    @Override
    public void render() { System.out.println("📺 Отображение приборной панели в кабине."); }
}
