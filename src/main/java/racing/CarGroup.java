package racing;

import static java.lang.System.*;

import java.util.HashMap;

/**
 * 자동차 그룹 클래스
 */
public class CarGroup {
    protected final HashMap<Integer, Car> cars;
    public final StringBuilder stringBuilder = new StringBuilder();

    public CarGroup(HashMap<Integer, Car> cars) {
        this.cars = cars;
    }

    /**
     * 자동차 단체 이동 메서드
     */
    public void go() {
        for (Car car : cars.values()) {
            car.move();
        }
    }

    /**
     * 자동차 그룹 위치 출력 메서드
     */
    public void printPosition() {
        for (int i=0; i<cars.size(); i++) {
            stringBuilder.append(cars.get(i).print()).append("\n");
        }
        out.println(stringBuilder.toString());
    }
}
