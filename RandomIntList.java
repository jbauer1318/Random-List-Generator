public class RandomIntList {
    private int[] nums;
    private int range;
    
    // -- constructors
    public RandomIntList(int how_many, int range) {
    // generates list of "how_many" random ints
    // each int in the range 0 - range, inclusive
        
        nums = new int[how_many];
        this.range = range;
        initList();
    }
    
    // -- factory methods
    public IntListItrInterface getAllValuesIterator(){
        return new AllValuesIterator(this,0);
    }
    
    public IntListItrInterface getEvenValuesIterator(){
        return new EvenValuesIterator(this,0);
    }
    
    // -- private methods
    private void initList(){
        Random rand_num_gen = new Random();
        
        for(int i = 0; i < nums.length; i++)
            nums[i] = rand_num_gen.nextInt(range+1);
    }
    
    // -- inner classes
    private class AllValuesIterator implements IntListItrInterface {
        private int current_index;
        private RandomIntList list;

        // -- constructors
        public AllValuesIterator(RandomIntList list, int start_loc){
            current_index = start_loc;
            this.list = list;
        }

        // -- iterator operators
        public boolean hasNext(){
            return current_index < list.nums.length;
        }

        public int next() throws InvalidIteratorOperationException {
            if(!hasNext())
                throw new InvalidIteratorOperationException();
            return list.nums[current_index++];
        }
    }
    
    private class EvenValuesIterator implements IntListItrInterface{
        private int current_index;
        private RandomIntList list;

        // -- constructors
        public EvenValuesIterator(RandomIntList list, int start_loc){
            current_index = start_loc;
            this.list = list;

            // set to first even in list
            if(!isEven())
                advanceToEven();
        }

        // -- iterator operators
        public boolean hasNext(){
            return !offEnd() && isEven();
        }

        public int next() throws InvalidIteratorOperationException {
            if(!hasNext())
                throw new InvalidIteratorOperationException();

            int return_val = list.nums[current_index];
            advanceToEven();
            return return_val;
        }

        // -- private methods
        private boolean isEven(){
            return (list.nums[current_index] % 2) == 0;
        }

        private void advanceToEven(){
            current_index = current_index + 1;

            while(!offEnd() && !isEven())
                current_index = current_index + 1;
        }

        private boolean offEnd(){
            return current_index == list.nums.length;
        }
    }

}