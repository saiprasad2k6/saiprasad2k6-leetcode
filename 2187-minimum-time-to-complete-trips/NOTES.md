```
int right = Arrays.stream(time).min().orElse(0) * totalTrips + 1;
```
​
This gives the worst case possibility of the minimum time taken. We can even choose the 10^5 as the right, but will have unecessary computations and will slow down the binary search.
​
```
return Arrays.stream(time)
.asLongStream()
.reduce(0L, (calculatedTotalTripTime, currentTripTime) -> calculatedTotalTripTime + (expectedTripTime / currentTripTime));
```
This is a clean method of calculating the sum of counts with computation.
​
* The function first converts the time array to a LongStream using the asLongStream() method of the Arrays class. This allows us to perform arithmetic operations on the elements of the array as long values, which avoids potential overflow issues when multiplying or dividing large integers.
* The function then uses the reduce() method of the LongStream class to calculate the sum of the floor division of m by each task completion time.
* The reduce() method takes an initial value of 0, which is the starting value for the reduction, and a lambda function that takes two arguments: a `calculatedTotalTripTime`, which is the accumulated result of the reduction so far, and an element of the stream `currentTripTime`, which is the next value to be processed.
* The lambda function calculates the floor division of m by the task completion time, and adds the result to the `calculatedTotalTripTime`.
* The reduce() method then returns the final result of the reduction, which is the total number of tasks that can be completed within the time limit `expectedTripTime`.
​
​
​