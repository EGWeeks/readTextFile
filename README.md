#Pseudocode:
 1. read in file to a string
 2. parse string into array, removing all non-alphanumeric characters. Except hyphens and apostrophe.
 3. create empty hash table key/value data structure
 4. iterate through array of words checking if the current word exists in as a key in the hash table
   * if it does exist increment value by one
   * if it does NOT exist create the word as a key with a initial value of one
 5. iterate through set of keys from hash table while length is greater than one
   * assign current key as most occurred
   * create another loop to iterate through same keys
     * if most occurred is less than nested loop current value then reassign it's value to that key
   * when inside loop has finished we push most occurred to an array
   * removed most occurred from key set
 6. return array