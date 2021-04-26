package fr.anatom3000.gwwhit;

public class Config {

    private static Config instance = null;
    private boolean thePill = false;
    private boolean godAliveStatus = true;
    private boolean RNGesusAliveStatus = true;
    private boolean mouseIsElectric = false;
    private boolean spin = false;
    private boolean registered = true;
    private boolean deepfried = false;

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

    public void register() {
        registered = !registered;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void deepfry() {
        if (deepfried) {
            deepfried = false;
            registered = true;
            thePill = false;
            spin = false;
            mouseIsElectric = true;
            RNGesusAliveStatus = true;
            godAliveStatus = true;
        } else {
            deepfried = true;
            registered = false;
            thePill = true;
            spin = true;
            mouseIsElectric = true;
            RNGesusAliveStatus = false;
            godAliveStatus = false;
        }
    }
}
