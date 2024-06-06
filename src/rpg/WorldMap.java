package rpg;

import java.util.HashMap;

public class WorldMap {
    private HashMap<String, String> locationInfo;

    public WorldMap() {
        locationInfo = new HashMap<>();
        initializeMap();
    }

    private void initializeMap() {
        locationInfo.put("마을", "마을 정보...");
        locationInfo.put("숲", "숲 정보...");
        locationInfo.put("동굴", "동굴 정보...");
    }

    // 지도 출력 메서드
    public void displayMap() {
        System.out.println("<세계 지도>");
        for (String location : locationInfo.keySet()) {
            System.out.println(location);
        }
    }

    // 지역 정보 반환 메서드
    public String getLocationInfo(String locationName) {
        return locationInfo.get(locationName);
    }

    // 지역 정보 업데이트 메서드
    public void updateLocationInfo(String locationName, String info) {
        locationInfo.put(locationName, info);
    }

    // 유효한 지역인지 확인하는 메서드
    public boolean isValidLocation(String locationName) {
        return locationInfo.containsKey(locationName);
    }
}
