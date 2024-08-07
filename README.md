## Challenge05 - SLAASCOM Software Engineering BootCamp
### Salary calculation process using Threads in Java.

<p align="justify"> This is a simple program that is done to explain and practice Threads in java. Thread is a flow of execution. Multiple threads mean multiple flows of execution. Threads allow a program to operate more efficiently by doing multiple things at the same time. It can be used to perform complicated tasks in the background without interrupting the main program just like a virtual CPU that can execute code inside of the java application. When threads execute, the priority of each thread varies. Higher-priority threads are executed before lower-priority threads.</p> <div>
There are few ways of creating threads: 
	<ol>
  	<li> Extend the “Thread” class and overriding its run () method.</li> 
        <li> Implement the runnable method.</li> 
        <li> Using Manual thread object.</li> 
	<li> Using future concurrency object. </li>
	</ol> </div>
                                                                     
According to the problem we must run two threads parallel to the main thread and should get the returned values from those to the main thread to calculate the final salary. 

* Main thread: Calculate the basic salary.  
    *	Basic salary = per day * no of days.
    * Final Salary = Basic salary + Allowance + Epf by employer – Epf by employee	
* 2<sup>nd</sup> thread: Calculate the allowances. 
    * Allowance = Basic salary * 0.05
* 3<sup>rd</sup> thread: Calculate Epf
    * Epf by employee = Basic salary * 0.08
    * Epf by employer = Basic salary * 0.12

<p align="justify"> To solve this problem, I used the "Future currency object" method. First I have imported the "java.util.concurrent." package which is most commonly used for asynchronous programming. Inside the main method, created two separate tasks using "future task" that can run parallelly and created two threads to fulfill necessary tasks. 2<sup>nd</sup> task is created as an array because it has two calculations to do under the thread (Epf by employee, Epf by employee). 
Next, run two tasks, call the tasks, and assign their results to new variables for calculating the final salary. 
Finally print the final result. </p> 

