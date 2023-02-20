``/**
* @param {number[]} nums
* @param {number} target
* @return {number}
*/
var searchInsert = function (nums, target) {
    let start = 0, end = nums.length -1;
    let index = 0;

    while (start <= end) {
        let mid = start + Math.floor((end - start) / 2);
        if (nums[mid] == target) {
            return mid;
        }
        if (target < nums[mid]) {
            end = mid - 1;
        } else {
            start = mid + 1;
            index = start;
        }
    }
    return index;
};