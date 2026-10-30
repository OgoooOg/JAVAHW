package ru.aston.homework3.proxy;

public class ProxyDashboardDisplay implements DashboardDisplay {
    private RealDashboardDisplay realDisplay;
    private String modelName;
    public ProxyDashboardDisplay(String modelName) { this.modelName = modelName; }
    @Override
    public void render() {
        if (realDisplay == null) { realDisplay = new RealDashboardDisplay(modelName); }
        realDisplay.render();
    }
}
