import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class TimeMap {

  public class Pair {
    String value;
    int timestamp;

    public Pair(String value, int timestamp) {
      this.value = value;
      this.timestamp = timestamp;
    }

    public String getValue() {
      return this.value;
    }

    public int getTimestamp() {
      return this.timestamp;
    }
  }

  Map<String, List<Pair>> data;

  public TimeMap() {
    data = new HashMap<>();
  }

  public void set(String key, String value, int timestamp) {
    Pair pair = new Pair(value, timestamp);
    List<Pair> temp = data.getOrDefault(key, new ArrayList<>());
    temp.add(pair);
    data.put(key, temp);
  }

  public String get(String key, int timestamp) {

    if (!data.containsKey(key))
      return "";

    List<Pair> va = new ArrayList<>(data.get(key));

    int start = 0, end = va.size();
    int mid = -1;
    while (start <= end) {
      mid = start + (end - start) / 2;
      if (va.get(mid).getTimestamp() == timestamp) {
        return va.get(mid).getValue();
      } else if (va.get(mid).getTimestamp() > timestamp) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    if (mid == -1)
      return "";
    return va.get(mid).getValue();
  }
}
