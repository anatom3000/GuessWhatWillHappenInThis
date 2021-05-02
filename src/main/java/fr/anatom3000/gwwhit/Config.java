package fr.anatom3000.gwwhit;

import com.google.common.collect.Maps;

import java.util.Map;

public class Config {
    private static Config instance = null;
    private final Map<String, Setting> settings = Maps.newHashMap();
    
    public static String SMALL_BLOCK_ENABLED_KEY = "small_blocks";
    public static String OWO_ENABLED_KEY = "owo";
    //public static String RANDOM_DROPS_ENABLED_KEY = "random_drops";
    public static String EARS_ENABLED_KEY = "ears";
    public static String SPIN_ENABLED_KEY = "spin";
    public static String DISABLE_FRUSTUM_CULLING_KEY = "kill_culling";
    public static String UNREGISTERED_ENABLED_KEY = "unregistered";
    public static String DINNERBONE_ENTITIES_ENABLED_KEY = "dinnerbone";
    public static final String DREAM_LUCK_ENABLED_KEY = "dream_luck";
    
    public static String[] ALL_CONFIG_KEYS = {
            SMALL_BLOCK_ENABLED_KEY,
            OWO_ENABLED_KEY,
            //RANDOM_DROPS_ENABLED_KEY,
            EARS_ENABLED_KEY,
            SPIN_ENABLED_KEY,
            DISABLE_FRUSTUM_CULLING_KEY,
            UNREGISTERED_ENABLED_KEY,
            DINNERBONE_ENTITIES_ENABLED_KEY,
            DREAM_LUCK_ENABLED_KEY
    };
    
    //Do NOT enable any config by default or make them enabled on false. This is for the future
    private Config(){
        put(SMALL_BLOCK_ENABLED_KEY, false, "§6[§eGWWHITM§6] §3You wake up!", "§6[§eGWWHITM§6] §3Everything stays the same!", true);
        put(OWO_ENABLED_KEY, false,"§6[§eGWWHITM§6] §3God is dead!", "§6[§eGWWHITM§6] §3God is alive!", false);
        //put(RNGESEUS_ALIVE_STATUS_KEY, false, "§6[§eGWWHITM§6] §3RNGesus is alive!", "§6[§eGWWHITM§6] §3RNGesus is dead!", false);
        put(EARS_ENABLED_KEY, false,"§6[§eGWWHITM§6] §3Let's get funky!", "§6[§eGWWHITM§6] §3Crispy Rat5", false);
        put(SPIN_ENABLED_KEY, false,"§6[§eGWWHITM§6] §3Achieved perfection!", "§6[§eGWWHITM§6] §3Bye, Johnny!", true);
        put(UNREGISTERED_ENABLED_KEY, false,"§6[§eGWWHITM§6] §3Unregistered!", "§6[§eGWWHITM§6] §3Registered!", false);
        put(DISABLE_FRUSTUM_CULLING_KEY, false,"§6[§eGWWHITM§6] §3Stopping culling!", "§6[§eGWWHITM§6] §3Culling!", true);
        put(DINNERBONE_ENTITIES_ENABLED_KEY, false,"§6[§eGWWHITM§6] §3Flipped!", "§6[§eGWWHITM§6] §3Flopped!", true);
        put(DREAM_LUCK_ENABLED_KEY, false,"§6[§eGWWHITM§6] §3It's not cheating anymore! \n§6[§eGWWHITM§6] §cRemember to reload!", "§6[§eGWWHITM§6] §3Oh wait, it is! \n§6[§eGWWHITM§6] §cRemember to reload!", false);
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
    
    private void put(String key, boolean value, String enableMsg, String disableMsg, boolean needReRender) {
        settings.put(key, new Setting(needReRender, value, enableMsg, disableMsg));
    }
    
    private Setting get(String key) {
        if (!settings.containsKey(key)) {
            GuessWhatWillHappenInThisMod.LOGGER.warn("Tried to get config value for unset key: " + key);
            put(key, false, "", "", false);
        }
        return settings.get(key);
    }
    
    
    public String getMsg(String key) {
        Setting s = get(key);
        return s.get() ? s.getEnableMsg() : s.getDisableMsg();
    }
    
    public boolean needsReRender(String key) {
        return get(key).needsReRender();
    }
    
    public boolean getValue(String key) {
        return get(key).get();
    }
    
    public void setValue(String key, boolean value) {
        get(key).set(value);
    }
    
    public void invertValue(String key) {
        get(key).invert();
    }
    
    //custom values are supported to enable syncing from server in the future
    public static final class Setting {
        private boolean value;
        private final boolean needsReRender;
        private final String enableMsg;
        private final String disableMsg;
    
        private Setting(boolean needReRender, boolean value, String enableMsg, String disableMsg) {
            this.needsReRender = needReRender;
            this.value = value;
            this.enableMsg = enableMsg;
            this.disableMsg = disableMsg;
        }
    
        public void invert() {
            value = !value;
        }
        
        public void set(boolean value) {
            this.value = value;
        }
        
        public boolean get() {
            return value;
        }
        
        public void reset() {
            this.value = false;
        }
    
        public String getEnableMsg() {
            return enableMsg;
        }
        public String getDisableMsg() {
            return disableMsg;
        }
    
        public boolean needsReRender() {
            return needsReRender;
        }
    }
}
