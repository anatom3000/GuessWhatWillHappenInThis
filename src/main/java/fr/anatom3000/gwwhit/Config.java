package fr.anatom3000.gwwhit;

public class Config {

    private static Config instance = null;
    private boolean thePill = true;
    private boolean godAliveStatus = true;
    private boolean RNGesusAliveStatus = true;
    private boolean mouseIsElectric = true;
    private boolean spin = true;

    private Config(){}

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public boolean isPillTaken() {
        return thePill;
    }

    public void takePill() {
        thePill = !thePill;
    }

    public boolean isGodDead() {
        return godAliveStatus;
    }

    public void killGod() {
        godAliveStatus = !godAliveStatus;
    }

    public boolean isRNGesusDead() {
        return RNGesusAliveStatus;
    }

    public void killRNGesus() {
        RNGesusAliveStatus = !RNGesusAliveStatus;
    }

    public boolean isMouseElectric() {
        return mouseIsElectric;
    }

    public void electrifyMouse() {
        mouseIsElectric = !mouseIsElectric;
    }

    public boolean spinIsUnlocked() {
        return spin;
    }

    public void changeSpin() {
        spin = !spin;
    }

}
