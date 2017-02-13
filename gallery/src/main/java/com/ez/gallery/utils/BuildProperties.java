package com.ez.gallery.utils;

public class BuildProperties {
 
    private final Properties properties;
 
    private BuildProperties() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(new File(Environment.getRootDirectory(), build.prop)));
    }
 
    public boolean containsKey(final Object key) {
        return properties.containsKey(key);
    }
 
    public boolean containsValue(final Object value) {
        return properties.containsValue(value);
    }
 
    public Set<entry<cke:object, object="">> entrySet() {
        return properties.entrySet();
    }
 
    public String getProperty(final String name) {
        return properties.getProperty(name);
    }
 
    public String getProperty(final String name, final String defaultValue) {
        return properties.getProperty(name, defaultValue);
    }
 
    public boolean isEmpty() {
        return properties.isEmpty();
    }
 
    public Enumeration<object> keys() {
        return properties.keys();
    }
 
    public Set<object> keySet() {
        return properties.keySet();
    }
 
    public int size() {
        return properties.size();
    }
 
    public Collection<object> values() {
        return properties.values();
    }
 
    public static BuildProperties newInstance() throws IOException {
        return new BuildProperties();
    }
 
}