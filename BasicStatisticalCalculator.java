import java.util.*;

public class BasicStatisticalCalculator {

    public static void main(String[] args) {
        // Example dataset
        double[] data = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        // Calculate and display statistics
        System.out.println("Dataset: " + Arrays.toString(data));
        System.out.println("Mean: " + calculateMean(data));
        System.out.println("Median: " + calculateMedian(data));
        System.out.println("Mode: " + calculateMode(data));
        System.out.println("Variance: " + calculateVariance(data));
        System.out.println("Standard Deviation: " + calculateStandardDeviation(data));
    }

    // Method to calculate the mean (average)
    public static double calculateMean(double[] data) {
        double sum = 0;
        for (double num : data) {
            sum += num;
        }
        return sum / data.length;
    }

    // Method to calculate the median (middle value)
    public static double calculateMedian(double[] data) {
        Arrays.sort(data);
        int middle = data.length / 2;
        if (data.length % 2 == 0) {
            return (data[middle - 1] + data[middle]) / 2.0;
        } else {
            return data[middle];
        }
    }

    // Method to calculate the mode (most frequently occurring value)
    public static List<Double> calculateMode(double[] data) {
        Map<Double, Integer> frequencyMap = new HashMap<>();
        for (double num : data) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxFrequency = Collections.max(frequencyMap.values());
        List<Double> modes = new ArrayList<>();
        for (Map.Entry<Double, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }
        return modes;
    }

    // Method to calculate the variance (The average of the squared differences from the mean)
    public static double calculateVariance(double[] data) {
        double mean = calculateMean(data);
        double sumSquaredDifferences = 0;
        for (double num : data) {
            sumSquaredDifferences += Math.pow(num - mean, 2);
        }
        return sumSquaredDifferences / data.length;
    }

    // Method to calculate the standard deviation (The square root of the variance)
    public static double calculateStandardDeviation(double[] data) {
        return Math.sqrt(calculateVariance(data));
    }
}
