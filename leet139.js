TC - O(n^3)
 SC - O(n)
/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function(s, wordDict) {
    var f = new Array(s.length + 1).fill(false);
	var set = new Set(wordDict);
	        f[0] = true;
		  for(var i=1; i <= s.length; i++){
	            for(var j=0; j < i; j++)
	                if(f[j] && set.has(s.substring(j, i))){
	                    f[i] = true;
	                    break;
	                
	            }
	        }
	        
	        return f[s.length];
};