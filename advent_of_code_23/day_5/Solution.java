import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static String printArrLongList(List<long[]> ls) {
        String sum = "";
        for (long[] item : ls) {
            sum += Arrays.toString(item);
        }
        return sum;
    }

    public static boolean isLineInfo(String line) {
        return line.charAt(0) >= 'a' && line.charAt(0) <= 'z';
    }

    public static void fillArrWithValues(List<long[]> ls, String line) {
        String[] mappers = line.split(" ");
        long[] interval = new long[] { Long.parseLong(mappers[0]), Long.parseLong(mappers[1]),
                Long.parseLong(mappers[2]) }; // [des_start_range, source_start_range,length]
        ls.add(interval);
    }

    public static List<Long> mapper(List<Long> source, List<long[]> dest) {
        int index = 0;
        for (long item : source) {
            for (int i = 0; i < dest.size(); i++) {
                long[] temp = dest.get(i); // des, source , length
                // System.out.println(item);
                if (item >= temp[1] && item <= temp[1] + temp[2]) {
                    // System.out.println(Arrays.toString(temp));
                    long diff = item - temp[1];
                    source.set(index, temp[0] + diff);
                    break;
                }
            }
            index++;
        }
        return source;
    }

    public static long minArr(List<Long> arr) {
        long min = Integer.MAX_VALUE;

        for (long num : arr) {
            min = Math.min(min, num);
        }
        return min;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("./input.txt"));

            List<Long> seeds = new ArrayList<>(); // to hold seeds to be planted
            List<long[]> seeds_to_soil = new ArrayList<>(); // mappers from seeds to soil
            List<long[]> soils_to_fertilizer = new ArrayList<>(); // mappers from soils to fertilizer
            List<long[]> fertilizer_to_water = new ArrayList<>(); // mappers from fertilizer to water
            List<long[]> water_to_light = new ArrayList<>(); // from water to light
            List<long[]> light_to_temperature = new ArrayList<>(); // from light to temperature
            List<long[]> temperature_to_humidity = new ArrayList<>();
            List<long[]> humidity_to_location = new ArrayList<>();

            AtomicInteger indexListToFill = new AtomicInteger(0);

            br.lines().forEach((line) -> {
                if (line.length() <= 0)
                    return;

                if (isLineInfo(line)) {
                    if (indexListToFill.get() == 0) {
                        indexListToFill.incrementAndGet();
                    } else {
                        indexListToFill.incrementAndGet();
                        return;
                    }
                }
                if (indexListToFill.get() == 1) {
                    String nums = line.split(": ")[1];
                    for (String num_item : nums.split(" ")) {
                        seeds.add(Long.parseLong(num_item));
                    }
                    // indexListToFill.incrementAndGet();
                    System.out.println(indexListToFill.get());
                } else if (indexListToFill.get() == 2) {
                    // seeds_to_soil
                    fillArrWithValues(seeds_to_soil, line);
                } else if (indexListToFill.get() == 3) {
                    // soil_to_fertilizer
                    fillArrWithValues(soils_to_fertilizer, line);
                } else if (indexListToFill.get() == 4) {
                    // fertilizer_to_water
                    fillArrWithValues(fertilizer_to_water, line);
                } else if (indexListToFill.get() == 5) {
                    // water_to_light
                    fillArrWithValues(water_to_light, line);
                } else if (indexListToFill.get() == 6) {
                    // light_to_temperature
                    fillArrWithValues(light_to_temperature, line);
                } else if (indexListToFill.get() == 7) {
                    // temperature_to_humidity
                    fillArrWithValues(temperature_to_humidity, line);
                } else if (indexListToFill.get() == 8) {
                    // humidity_location
                    fillArrWithValues(humidity_to_location, line);
                }

            });

            System.out.println(seeds);
            System.out.println(printArrLongList(seeds_to_soil));
            System.out.println(printArrLongList(soils_to_fertilizer));
            System.out.println(printArrLongList(fertilizer_to_water));
            System.out.println(printArrLongList(water_to_light));
            System.out.println(printArrLongList(light_to_temperature));
            System.out.println(printArrLongList(temperature_to_humidity));
            System.out.println(printArrLongList(humidity_to_location));

            List<Long> result = new ArrayList<>(seeds);
            for (int i = 1; i <= 7; i++) {
                switch (i) {
                    case 1:
                        result = mapper(result, seeds_to_soil);
                        System.out.println(result);
                        break;
                    case 2:
                        result = mapper(result, soils_to_fertilizer);
                        System.out.println(result);
                        break;
                    case 3:
                        result = mapper(result, fertilizer_to_water);
                        System.out.println(result);
                        break;
                    case 4:
                        result = mapper(result, water_to_light);
                        System.out.println(result);
                        break;
                    case 5:
                        result = mapper(result, light_to_temperature);
                        System.out.println(result);
                        break;
                    case 6:
                        result = mapper(result, temperature_to_humidity);
                        System.out.println(result);
                        break;
                    case 7:
                        result = mapper(result, humidity_to_location);
                        System.out.println(result);
                        break;
                    default:
                        break;
                }
            }

            System.out.println(minArr(result));

            //
            br.close();

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            e.printStackTrace();

        }
    }

}
