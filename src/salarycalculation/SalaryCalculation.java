package salarycalculation;
import java.util.concurrent.*;

public class SalaryCalculation {
    public static void main(String[] args)throws ExecutionException, InterruptedException 
    {
        CompletableFuture<Double> allowanceFutureTask = new CompletableFuture<>();
        CompletableFuture<Double[]> epfFutureTask = new CompletableFuture<>();
        
        double perDayPayement = 3000;
        double numOfDays = 20;
        double basicSalary = perDayPayement * numOfDays;
        
        Thread allowanceCalculator = new Thread(new Runnable() {
      @Override
      public void run() {
        allowanceFutureTask.complete(basicSalary * 0.05);
      }
    });

    Thread epfCalculator = new Thread(new Runnable() {
      @Override
      public void run() {
        double epfByEmployee = basicSalary * 0.08;
        double epfByEmployer = basicSalary * 0.12;
        epfFutureTask.complete(new Double[] { epfByEmployee, epfByEmployer });
      }
    });

    allowanceCalculator.start();
    epfCalculator.start();
    
    double allowance = allowanceFutureTask.get();
    double epfByEmployee = epfFutureTask.get()[0];
    double epfByEmployer = epfFutureTask.get()[1];

    double finalSalary = basicSalary + allowance + epfByEmployer - epfByEmployee;
	
    System.out.println(String.format("Basic Salary: %.2f",basicSalary));
    System.out.println(String.format("Allowance: %.2f",allowance));
    System.out.println(String.format("epfByEmployee: %.2f",epfByEmployee));
    System.out.println(String.format("epfByEmployer: %.2f",epfByEmployer));
    System.out.println(String.format("Total Salary: %.2f", finalSalary));
     
    }   
}



