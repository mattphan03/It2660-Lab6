public class Main {
  public static void main(String[] args) {
      MyMap<String, Integer> creditHours = new MyHashMap<>();

      creditHours.put("IT-1025", 3);
      creditHours.put("IT-1050", 3);
      creditHours.put("IT-1150", 3);
      creditHours.put("IT-2310", 3);
      creditHours.put("IT-2320", 4);
      creditHours.put("IT-2351", 4);
      creditHours.put("IT-2650", 4);
      creditHours.put("IT-2660", 4);
      creditHours.put("IT-2030", 4);

      System.out.println("Contains IT-1025? " + creditHours.containsKey("IT-1025")); // true
      System.out.println("Contains IT-2110? " + creditHours.containsKey("IT-2110")); // false

      System.out.println("\nAll values in map:");
      for (MyMap.Entry<String, Integer> entry : creditHours.entrySet()) {
          System.out.println(entry);
      }

      creditHours.remove("IT-2030");
      creditHours.remove("IT-1150");

      System.out.println("\nAfter removals:");
      for (MyMap.Entry<String, Integer> entry : creditHours.entrySet()) {
          System.out.println(entry);
      }
  }
}
