TC - O(m*n)
SC -  O(m*n)

/**
 * @param {number} m
 * @param {number} n
 * @return {number}
 */
var uniquePaths = function(m, n) {
    var mem= new Array(m+1).fill(0);
    for(let i=0;i<mem.length;i++){
        mem[i]=new Array(n+1).fill(-1);
    }
    return helper(m,n,1,1,mem);
};
var helper = function(m,n,row,col,mem){
    if(row===m && col===n){
        return 1;
    }
    if(row>m || col>n)return 0;
    if(mem[row][col]===-1){
    var right = helper(m,n,row+1,col,mem);
    var left = helper(m,n,row,col+1,mem);
    mem[row][col] = right+left;
    }
    return mem[row][col];
};