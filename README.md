# IS-2545-Deliverable-4

Firstly, I clicked some grey buttons and ran the program continuously. The issue was coming out in the __<h3>convertToInt()</h3>__ function since it takes the most CPU time. I modified it by deleting for loop. I assigned a string builder and appended a character array with 1,000 elements where I replaced empty value to zero. 

Then then problem fixed when I ran it for the second time. However, the new issue was coming out in the __runContinuous()__ function. I noticed there was the loop for assigning _r. It ran 10000 times in the loop. However, _r was reassigned to the original value after the loop. Therefore, the loop is unnecessary and I deleted it. In addition, there were multiple treads in the sleep condition, which means they took up to much CPU time. I deleted that code also. The bug was also fixed. 

The third problem was coming out in the constructor of Cell(). I think there is no need to fix the constructor since it is called by other method when it was instantiated. Thus, I focused on __backup()__ function since it called Cell() method. Since the backup() function is used for storing the current iteration, I just assign backup iteration to the clone of current iteration without calling Cell() method.

After the third problem was fixed, __convertToInt()__ function took the most CPU time again so I checked the method again. This time I found that the purpose of the method is quite simple. All we need to do is just return the integer value which is the parameter of this method. We do not even have to assign a string builder and append 1,000 zeros before we append the parameter. The problem fixed and it should not be the trouble in the program anymore.

I have tried my best to test the performance of running program. Then I focused on the other performing such as clicking write button. Originally, clicking write button would take some time to get the file written. After checking VisualVM, I found that the issue was occurring in __Cell.toString()__ method. There was a loop which is run 10,000 times once the method is called. I noticed that toReturn value was assigned constantly. However, after the loop, the method just takes a substring of toReturn, which is just the first character. Therefore, no matter how many times the loop would run, the useful value is just the original toReturn value and I deleted the loop. The problem solved.

Firstly, I ran the program, the issue was coming out in the convertToInt() function

![alt tag](https://github.com/lvkaiyang/IS-2545-Deliverable-4/blob/master/1.png)

After refactoring

![alt tag](https://github.com/lvkaiyang/IS-2545-Deliverable-4/blob/master/2.png)

The issue occurring in the Cell.toString() method

![alt tag](https://github.com/lvkaiyang/IS-2545-Deliverable-4/blob/master/3.jpg)

After refactoring

![alt tag](https://github.com/lvkaiyang/IS-2545-Deliverable-4/blob/master/4.jpg)
