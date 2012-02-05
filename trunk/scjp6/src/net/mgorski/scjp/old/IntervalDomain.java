package net.mgorski.scjp.old;

import java.util.ArrayList;
import java.util.List;

public class IntervalDomain
    extends AbstractNumericalValue implements Cloneable
{
        
        /**
     * 
     */
    private static final long serialVersionUID = 1L;
    static final private int THRESHOLD_VALUE = 20;
        static final private int MAX_DISTANCE = 1;
        
        private List intervals;
        

    public IntervalDomain()
    {
        this.intervals = new ArrayList();
        intervals.add(new Interval());
        //lowerBound = 1L;
        //upperBound = -1L;
    }

    public IntervalDomain(Interval interval) //long minValue, long maxValue)
    {
        this.intervals = new ArrayList();
        intervals.add(interval);
        //lowerBound = l;
        //upperBound = h;
        //this.firstType = firstType;
    }
    
    public IntervalDomain(List intervals)
    {
        this.intervals = intervals;
    }

    public List getIntervals() {
        return new ArrayList(this.intervals);
    }
    
//    private boolean checkType(NumericalValue v1, NumericalValue v2)
//    {
//        return (v1 instanceof IntervalDomain) && (v2 instanceof IntervalDomain);
//    }


    private boolean isBottom()
    {
        return this.getLowestDomainBound() == Long.MIN_VALUE && this.getLowestDomainBound() == this.getUppestDomainBound();
    }

    private boolean isTop()
    {
        return this.getLowestDomainBound() == Long.MIN_VALUE && this.getUppestDomainBound() == Long.MAX_VALUE;
       // return lowerBound == 0x8000000000000000L && upperBound == 0x7fffffffffffffffL;
    }

//    private long min(long a, long b)
//    {
//        if(a < b)
//            return a;
//        else
//            return b;
//    }

//    private long max(long a, long b)
//    {
//        if(a > b)
//            return a;
//        else
//            return b;
//    }

//    private long min(long a, long b, long c, long d)
//    {
//        long res = min(a, b);
//        res = min(res, c);
//        return min(res, d);
//    }

//    private long max(long a, long b, long c, long d)
//    {
//        long res = max(a, b);
//        res = max(res, c);
//        return max(res, d);
//    }

//    private IntervalDomain intersect(IntervalDomain v)
//    {
//        if(isTop())
//            return v;
//        if(v.isTop())
//            return this;
//        else
//            return new IntervalDomain(max(lowerBound, v.lowerBound), min(upperBound,
//v.upperBound), firstType);
//    }

    /*
     * Unisce intervalli adiacenti del dominio che abbiano distanza tra upBound e LowBound <= MAX_DISTANCE
     *  Restituisce il numero di volte che sono stati mergiati gli intervalli, ovvero restituisce il numero di intervalli mergiati / 2
     */
    private int mergeBounds() {
        int counter = 0;
        
        for (int i = 0 ; i < this.intervals.size() - 1 ; i++) {
                Interval firstInterval = (Interval) this.intervals.get(i);
                Interval secondInterval = (Interval) this.intervals.get(i + 1);

                if ((secondInterval.getLowerBound() - firstInterval.getUpperBound()) <= MAX_DISTANCE) {
                        Interval newInterval = new Interval(firstInterval.getLowerBound(), secondInterval.getUpperBound());
                        this.intervals.add(newInterval); // aumento la cardinalità di uno (size = size + 1)
                        this.intervals.remove(i + 1); // ...perchè in i adesso c'è il nuovo intervallo
                        this.intervals.remove(i + 1); // ...perchè ho tolto l'intervallo precedente
                        i--; // ...perchè ho ridotto la cardinalità dell'insieme e riparto dall'elemento nuovo appena inserito
                        counter++;
                }
                
        }
        
        return counter;
    }
   
    
    public void insertNewInterval(Interval interval) {
        Interval newInterval = interval.clona();
        
        int i;
        
        // base case
        if (interval.getLowerBound() == Long.MIN_VALUE) {
                
        }
        
        // we'll start to read intervals already exist
        for (i = 0 ; i < this.intervals.size() ; i++) {
                Interval currentInterval = (Interval) this.intervals.get(i);
                
                // if the new interval is already in an existent one, we can avoid the insertion -- ok
                if (currentInterval.getLowerBound() <= newInterval.getLowerBound() && currentInterval.getUpperBound() >= newInterval.getUpperBound()) {
                        break;
                }
                
                // if two intervals are adjacent we can "merge" them or
                // if the newInterval intersect the last part of the current one, we can change the first value of the newInterval and go on
                if (((currentInterval.getUpperBound() == (newInterval.getLowerBound() - 1)) && newInterval.getLowerBound() != Long.MIN_VALUE) || (currentInterval.getLowerBound() <= newInterval.getLowerBound() && currentInterval.getUpperBound() >= newInterval.getLowerBound() && currentInterval.getUpperBound() <= newInterval.getUpperBound())) {
                        newInterval.setLowerBound(currentInterval.getLowerBound());
                        this.intervals.remove(i--);
                        continue;
                }

                // if two intervals are adjacent we can "merge" them OR
                // if the newInterval intersect the first part of the current one, we can change the last value of the newInterval and go on
                if (((currentInterval.getLowerBound() == (newInterval.getUpperBound() + 1)) && newInterval.getUpperBound() != Long.MAX_VALUE) || (currentInterval.getUpperBound() >= newInterval.getUpperBound() && currentInterval.getLowerBound() <= newInterval.getUpperBound() && currentInterval.getLowerBound() >= newInterval.getLowerBound())) {
                        newInterval.setUpperBound(currentInterval.getUpperBound());
                        this.intervals.remove(i--);
                        continue;
                }
                
                
                // if the new interval doesn't intersect any part of the current interval and is lower, we can add the interval
                if (currentInterval.getLowerBound() > newInterval.getUpperBound()) {
                        this.intervals.add(i, newInterval);
                        break;
                }
                
        }
        
        // if all existent intervals were passed on or there are not intervals yet, then we can add the new interval at the end
        if (i == this.intervals.size()) {
                this.intervals.add(newInterval);
        }
    }

    

//    public NumericalValue and(NumericalValue v1, NumericalValue v2)
//        throws SemanticException
//    {
//        if(!checkType(v1, v2))
//            throw new SemanticException("I cannot perform an arithmetic operations with different domains",
//name.ferrara.pietro.checkmate.abstractdomain.SemanticException.Error.DomainError);
//        IntervalDomain val1 = (IntervalDomain)v1;
//        IntervalDomain val2 = (IntervalDomain)v2;
//        if(val1.equals(new IntervalDomain(0L, 0L, v1.categoryType() == 1)) ||
//val2.equals(new IntervalDomain(0L, 0L, v1.categoryType() == 1)))
//            return new IntervalDomain(0L, 0L, v1.categoryType() == 1);
//        if(val1.equals(new IntervalDomain(1L, 1L, v1.categoryType() == 1)) &&
//val2.equals(new IntervalDomain(1L, 1L, v1.categoryType() == 1)))
//            return new IntervalDomain(1L, 1L, v1.categoryType() == 1);
//        else
//            return new IntervalDomain(0x8000000000000000L, 0x7fffffffffffffffL,
//v1.categoryType() == 1);
//    }

    // ritorna il valore MINIMO tra i 4 passati come parametro
    private long calculateMin(long value1, long value2, long value3, long value4) {
        long minValue = value1 < value2 ? value1 : value2;
        minValue = minValue < value3 ? minValue : value3;
        minValue = minValue < value4 ? minValue : value4;
        
        return minValue;
    }
    
    // ritorna il valore MASSIMO tra i 4 passati come parametro
    private long calculateMax(long value1, long value2, long value3, long value4) {
        long maxValue = value1 > value2 ? value1 : value2;
        maxValue = maxValue > value3 ? maxValue : value3;
        maxValue = maxValue > value4 ? maxValue : value4;
        
        return maxValue;
    }
    


   

   

//    public NumericalValue or(NumericalValue v1, NumericalValue v2)
//        throws SemanticException
//    {
//        if(!checkType(v1, v2))
//            throw new SemanticException("I cannot perform an arithmetic operations with different domains",
//name.ferrara.pietro.checkmate.abstractdomain.SemanticException.Error.DomainError);
//        IntervalDomain val1 = (IntervalDomain)v1;
//        IntervalDomain val2 = (IntervalDomain)v2;
//        if(val1.equals(new IntervalDomain(0L, 0L, v1.categoryType() == 1)) &&
//val2.equals(new IntervalDomain(0L, 0L, v1.categoryType() == 1)))
//            return new IntervalDomain(0L, 0L, v1.categoryType() == 1);
//        if(val1.equals(new IntervalDomain(1L, 1L, v1.categoryType() == 1)) ||
//val2.equals(new IntervalDomain(1L, 1L, v1.categoryType() == 1)))
//            return new IntervalDomain(1L, 1L, v1.categoryType() == 1);
//        else
//            return new IntervalDomain(0x8000000000000000L, 0x7fffffffffffffffL,
//v1.categoryType() == 1);
//    }

   

//    public NumericalValue remainder(NumericalValue v1, NumericalValue v2)
//        throws SemanticException
//    {
//        return new IntervalDomain(0x8000000000000000L, 0x7fffffffffffffffL,
//v1.categoryType() == 1);
//    }

//    public NumericalValue leftshift(NumericalValue v1, NumericalValue v2)
//        throws SemanticException
//    {
//        return new IntervalDomain(0x8000000000000000L, 0x7fffffffffffffffL,
//v1.categoryType() == 1);
//    }

//    public NumericalValue arithmeticalrightshift(NumericalValue v1, NumericalValue v2)
//        throws SemanticException
//    {
//        return new IntervalDomain(0x8000000000000000L, 0x7fffffffffffffffL,
//v1.categoryType() == 1);
//    }

//    public NumericalValue logicalrightshift(NumericalValue v1, NumericalValue v2)
//        throws SemanticException
//    {
//        return new IntervalDomain(0x8000000000000000L, 0x7fffffffffffffffL,
//v1.categoryType() == 1);
//    }

//    public NumericalValue xor(NumericalValue v1, NumericalValue v2)
//        throws SemanticException
//    {
//        return new IntervalDomain(0x8000000000000000L, 0x7fffffffffffffffL,
//v1.categoryType() == 1);
//    }







//    public int categoryType()
//    {
//        return !firstType ? 2 : 1;
//    }

//    public void setCategoryType(int i)
//    {
//        firstType = i == 1;
//    }
    
        public long getLowestDomainBound() {
                return ((Interval) this.intervals.get(0)).getLowerBound();
        }

        public long getUppestDomainBound() {
                return ((Interval) this.intervals.get(this.intervals.size() - 1)).getUpperBound();
        }

        
//==============================================================================================================================
        //==============================================================================================================================
        //==============================================================================================================================
        //==============================================================================================================================
        //==============================================================================================================================
        //==============================================================================================================================
        //==============================================================================================================================
        //==============================================================================================================================
        
        
        public NumericalValue add(NumericalValue arg0, NumericalValue arg1)
        throws SemanticException {
                //if(!checkType(arg0, arg1))
//          throw new SemanticException("I cannot perform an arithmetic operations with different domains",
//name.ferrara.pietro.checkmate.abstractdomain.SemanticException.Error.DomainError);
        List v1Intervals = ((IntervalDomain) arg0).getIntervals();
        List v2Intervals = ((IntervalDomain) arg1).getIntervals();
        
        IntervalDomain newIntervalDomain = null;
        
        // the addition must be done between first list intervals and second list intervals
        for (int i = 0 ; i < v1Intervals.size() ; i++) {
                Interval interval1 = (Interval) v1Intervals.get(i);
                for (int j = 0 ; j < v2Intervals.size() ; j++) {
                        Interval interval2 = (Interval) v2Intervals.get(j);
                        
                        // here it is calculated new single interval
                        long addedValue1 = (interval1.getLowerBound() == Long.MIN_VALUE || interval2.getLowerBound() == Long.MIN_VALUE) ?
                                        Long.MIN_VALUE : 
                                                ((interval1.getLowerBound() == Long.MAX_VALUE || interval2.getLowerBound() == Long.MAX_VALUE) ?
                                                                Long.MAX_VALUE :
                                                                        interval1.getLowerBound() + interval2.getLowerBound()); 

                        long addedValue2 = (interval1.getLowerBound() == Long.MIN_VALUE || interval2.getUpperBound() == Long.MIN_VALUE) ?
                                        Long.MIN_VALUE : 
                                                ((interval1.getLowerBound() == Long.MAX_VALUE || interval2.getUpperBound() == Long.MAX_VALUE) ?
                                                                Long.MAX_VALUE :
                                                                        interval1.getLowerBound() + interval2.getUpperBound()); 

                        long addedValue3 = (interval1.getUpperBound() == Long.MIN_VALUE || interval2.getLowerBound() == Long.MIN_VALUE) ?
                                        Long.MIN_VALUE : 
                                                ((interval1.getUpperBound() == Long.MAX_VALUE || interval2.getLowerBound() == Long.MAX_VALUE) ?
                                                                Long.MAX_VALUE :
                                                                        interval1.getUpperBound() + interval2.getLowerBound());

                        long addedValue4 = (interval1.getUpperBound() == Long.MIN_VALUE || interval2.getUpperBound() == Long.MIN_VALUE) ?
                                        Long.MIN_VALUE : 
                                                ((interval1.getUpperBound() == Long.MAX_VALUE || interval2.getUpperBound() == Long.MAX_VALUE) ?
                                                                Long.MAX_VALUE :
                                                                        interval1.getUpperBound() + interval2.getUpperBound()); 

                        long newLowBound = calculateMin(addedValue1, addedValue2, addedValue3, addedValue4);
                        long newUpBound = calculateMax(addedValue1, addedValue2, addedValue3, addedValue4);
                        
//                      long newLowBound = (interval1.getLowerBound() == Long.MIN_VALUE || interval2.getLowerBound() == Long.MIN_VALUE) ?
//                                                              Long.MIN_VALUE : 
//                                                              ((interval1.getLowerBound() == Long.MAX_VALUE || interval2.getLowerBound() == Long.MAX_VALUE) ?
//                                                               Long.MAX_VALUE :
//                                                               interval1.getLowerBound() + interval2.getLowerBound());
//                      long newUpBound = (interval1.getUpperBound() == Long.MIN_VALUE || interval2.getUpperBound() == Long.MIN_VALUE) ?
//                                                          Long.MIN_VALUE : 
//                                                              ((interval1.getUpperBound() == Long.MAX_VALUE || interval2.getUpperBound() == Long.MAX_VALUE) ?
//                                                               Long.MAX_VALUE :
//                                                               interval1.getUpperBound() + interval2.getUpperBound()); 
                        
                        if (newIntervalDomain == null) { // first time i create an interval for this list
                                List firstInterval = new ArrayList();
                                firstInterval.add(new Interval(newLowBound, newUpBound));
                                newIntervalDomain = new IntervalDomain(firstInterval);
                        } else {
                                newIntervalDomain.insertNewInterval(new Interval(newLowBound, newUpBound));
                        }
                }
        }
        
        return newIntervalDomain;
        
//      IntervalDomain val1 = (IntervalDomain)v1;
//      IntervalDomain val2 = (IntervalDomain)v2;
//      long up;
//      if(val1.upperBound == 0x7fffffffffffffffL || val2.upperBound ==
//0x7fffffffffffffffL)
//          up = 0x7fffffffffffffffL;
//      else
//          up = val1.upperBound + val2.upperBound;
//      long down;
//      if(val1.lowerBound == 0x8000000000000000L || val2.lowerBound ==
//0x8000000000000000L)
//          down = 0x8000000000000000L;
//      else
//          down = val1.lowerBound + val2.lowerBound;
//      return new IntervalDomain(down, up, v1.categoryType() == 1);
}

public NumericalValue clone() {
    return new IntervalDomain(this.intervals);
}

public NumericalValue divide(NumericalValue arg0, NumericalValue arg1)
        throws SemanticException {
        List v1Intervals = ((IntervalDomain) arg0).getIntervals();
        List v2Intervals = ((IntervalDomain) arg1).getIntervals();
        
        IntervalDomain newIntervalDomain = null;
        
        // the addition must be done between first list intervals and second list intervals
        for (int i = 0 ; i < v1Intervals.size() ; i++) {
                Interval interval1 = (Interval) v1Intervals.get(i);
                for (int j = 0 ; j < v2Intervals.size() ; j++) {
                        Interval interval2 = (Interval) v2Intervals.get(j);
                        
                        // here it is calculated new single interval
                        long dividedValue1 = (interval1.getLowerBound() == Long.MIN_VALUE || interval2.getLowerBound() == Long.MIN_VALUE) ?
                                                                   Long.MIN_VALUE : 
                                                                   ((interval1.getLowerBound() == Long.MAX_VALUE || interval2.getLowerBound() == Long.MAX_VALUE) ?
                                                                    Long.MAX_VALUE :
                                                                    interval1.getLowerBound() / interval2.getLowerBound()); 
                                
                        long dividedValue2 = (interval1.getLowerBound() == Long.MIN_VALUE || interval2.getUpperBound() == Long.MIN_VALUE) ?
                                                      Long.MIN_VALUE : 
                                                          ((interval1.getLowerBound() == Long.MAX_VALUE || interval2.getUpperBound() == Long.MAX_VALUE) ?
                                                           Long.MAX_VALUE :
                                                           interval1.getLowerBound() / interval2.getUpperBound()); 
                                
                        long dividedValue3 = (interval1.getUpperBound() == Long.MIN_VALUE || interval2.getLowerBound() == Long.MIN_VALUE) ?
                                                  Long.MIN_VALUE : 
                                                  ((interval1.getUpperBound() == Long.MAX_VALUE || interval2.getLowerBound() == Long.MAX_VALUE) ?
                                                   Long.MAX_VALUE :
                                                   interval1.getUpperBound() / interval2.getLowerBound());
                                
                                
                        long dividedValue4 = (interval1.getUpperBound() == Long.MIN_VALUE || interval2.getUpperBound() == Long.MIN_VALUE) ?
                                              Long.MIN_VALUE : 
                                          ((interval1.getUpperBound() == Long.MAX_VALUE || interval2.getUpperBound() == Long.MAX_VALUE) ?
                                           Long.MAX_VALUE :
                                           interval1.getUpperBound() / interval2.getUpperBound()); 
                                
                        long newLowBound = calculateMin(dividedValue1, dividedValue2, dividedValue3, dividedValue4);
                        long newUpBound = calculateMax(dividedValue1, dividedValue2, dividedValue3, dividedValue4);
                        
                        if (newIntervalDomain == null) { // first time i create an interval for this list
                                List firstInterval = new ArrayList();
                                firstInterval.add(new Interval(newLowBound, newUpBound));
                                newIntervalDomain = new IntervalDomain(firstInterval);
                        } else {
                                newIntervalDomain.insertNewInterval(new Interval(newLowBound, newUpBound));
                        }
                }
        }
        
        return newIntervalDomain;
        
//    if(!checkType(v1, v2))
//        throw new SemanticException("I cannot perform an arithmetic operations with different domains",
//name.ferrara.pietro.checkmate.abstractdomain.SemanticException.Error.DomainError);
//    IntervalDomain val1 = (IntervalDomain)v1;
//    IntervalDomain val2 = (IntervalDomain)v2;
//    long l1;
//    long l3;
//    if(val2.lowerBound != 0L)
//    {
//        l1 = val1.lowerBound / val2.lowerBound;
//        l3 = val1.upperBound / val2.lowerBound;
//    } else
//    {
//        if(val1.lowerBound > 0L)
//            l1 = 0x7fffffffffffffffL;
//        else
//            l1 = 0x8000000000000000L;
//        if(val1.upperBound > 0L)
//            l3 = 0x7fffffffffffffffL;
//        else
//            l3 = 0x8000000000000000L;
//    }
//    long l2;
//    long l4;
//    if(val2.upperBound != 0L)
//    {
//        l2 = val1.lowerBound / val2.upperBound;
//        l4 = val1.upperBound / val2.upperBound;
//    } else
//    {
//        if(val1.lowerBound > 0L)
//            l2 = 0x7fffffffffffffffL;
//        else
//            l2 = 0x8000000000000000L;
//        if(val1.upperBound > 0L)
//            l4 = 0x7fffffffffffffffL;
//        else
//            l4 = 0x8000000000000000L;
//    }
//    return new IntervalDomain(min(l1, l2, l3, l4), max(l1, l2, l3, l4),
//v1.categoryType() == 1);
}

public boolean equals(Object arg0) {
        if(!(arg0 instanceof IntervalDomain))
        return false;
    
        List objIntervals = ((IntervalDomain) arg0).getIntervals();
        
        // first of all we'll check the intervals size and lowest/uppest bounds
        if (this.intervals.size() != objIntervals.size() ||
                this.getLowestDomainBound() != ((IntervalDomain) arg0).getLowestDomainBound() ||
                this.getUppestDomainBound() != ((IntervalDomain) arg0).getUppestDomainBound()) {
                return false;
        }
        
        for (int i = 0 ; i < this.intervals.size() ; i++) {
                if (((Interval) this.intervals.get(i)).getLowerBound() != ((Interval) objIntervals.get(i)).getLowerBound() ||
                         ((Interval) this.intervals.get(i)).getUpperBound() != ((Interval) objIntervals.get(i)).getUpperBound()) {
                        return false;
                }
        }
        
    return true; 
//    if(isBottom() && ((IntervalDomain)o).isBottom())
//        return true;
//    return lowerBound == ((IntervalDomain)o).lowerBound && upperBound ==
//((IntervalDomain)o).upperBound && firstType ==
//((IntervalDomain)o).firstType;
}

public NumericalValue evalConstant(long arg0, boolean arg1)
        throws SemanticException {
    return new IntervalDomain(new Interval(arg0, arg0)/*, arg1*/);
}

public int hashCode() {
    return (int) getLowestDomainBound();
}

public boolean lessEqual(NumericalValue arg0) throws SemanticException {

        if(!(arg0 instanceof IntervalDomain))
        return false;
    
        List objIntervals = ((IntervalDomain) arg0).getIntervals();
        
        for (int i = 0 ; i < objIntervals.size() ; i++) {
                int j = 0;
                for (j = 0 ; j < this.intervals.size() ; j++) {
                        if (((Interval) this.intervals.get(j)).getLowerBound() >= ((Interval) objIntervals.get(i)).getLowerBound() &&
                                ((Interval) this.intervals.get(j)).getUpperBound() <= ((Interval) objIntervals.get(i)).getUpperBound()) {
                                        break;
                        }
                }
                
                if (j == this.intervals.size()) {
                        return false;
                }
        } 
        
    return true;
        
        
//      List objIntervals = ((IntervalDomain) arg0).getIntervals();
//      
//      // first of all we'll check the intervals lowest/uppest bounds
//      if (this.getLowestDomainBound() < ((IntervalDomain) arg0).getLowestDomainBound() &&
//              this.getUppestDomainBound() > ((IntervalDomain) arg0).getUppestDomainBound()) {
//              return false;
//      }
//      
//      int dim1 = 0;
//      for (int i = 0 ; i < this.intervals.size() ; i++) {
//              dim1 += ((Interval) this.intervals.get(i)).getUpperBound() - ((Interval) this.intervals.get(i)).getLowerBound(); 
//      }
//      
//      int dim2 = 0;
//      for (int i = 0 ; i < objIntervals.size() ; i++) {
//              dim2 += ((Interval) objIntervals.get(i)).getUpperBound() - ((Interval) objIntervals.get(i)).getLowerBound(); 
//      }
//      
//    return dim1 <= dim2; 
        
        
//      return this.equals(arg0);
//  if(!(v instanceof IntervalDomain))
//      throw new SemanticException("Cannot compare numerical values belonging to different domains",
//name.ferrara.pietro.checkmate.abstractdomain.SemanticException.Error.DomainError);
//  return intersect((IntervalDomain)v).equals(this);
}

public NumericalValue lub(NumericalValue arg0, NumericalValue arg1)
        throws SemanticException {
        
        IntervalDomain newIntervalDomain = null;

        List intervals1 = ((IntervalDomain) arg0).getIntervals();
        List intervals2 = ((IntervalDomain) arg1).getIntervals();

        // System.out.println("WIDENING");

        if (intervals1 != null) {
                newIntervalDomain = new IntervalDomain(intervals1);
        }
        
//      for (int i = 0 ; i < intervals1.size() ; i++) {
//              Interval interval = (Interval)intervals1.get(i);
//              if (newIntervalDomain == null) {
//                      List firstInterval = new ArrayList();
//                      firstInterval.add(new Interval(interval.getLowerBound(), interval.getUpperBound()));
//                      newIntervalDomain = new IntervalDomain(firstInterval);
//              } else {
//                      newIntervalDomain.insertNewInterval(new Interval(interval.getLowerBound(), interval.getUpperBound()));
//              }
//      }

        for (int i = 0 ; i < intervals2.size() ; i++) {
                Interval interval = (Interval)intervals2.get(i);
                if (newIntervalDomain == null) {
                        newIntervalDomain = new IntervalDomain(new Interval(interval.getLowerBound(), interval.getUpperBound()));
                } else {
                        newIntervalDomain.insertNewInterval(new Interval(interval.getLowerBound(), interval.getUpperBound()));
                }
        }

//      if (this.intervals.size() > THRESHOLD_VALUE) {
//              int intervalsMerged = this.mergeBounds();
//              // if the number of intervals merged is greater than 0 means we have reduced the cardinality and we can go on...
//              // ...otherwise, if no intervals were deleted, the threshold is overcome and we return TOP element.
//      }
        
        return newIntervalDomain;
        
//  if(!checkType(v1, v2))
//      throw new SemanticException("I cannot perform an arithmetic operations with different domains",
//name.ferrara.pietro.checkmate.abstractdomain.SemanticException.Error.DomainError);
//  else
//      return new IntervalDomain(min(((IntervalDomain)v1).lowerBound,
//((IntervalDomain)v2).lowerBound), max(((IntervalDomain)v1).upperBound,
//((IntervalDomain)v2).upperBound), v1.categoryType() == 1);
}

public NumericalValue multiply(NumericalValue arg0, NumericalValue arg1)
        throws SemanticException {
        List v1Intervals = ((IntervalDomain) arg0).getIntervals();
        List v2Intervals = ((IntervalDomain) arg1).getIntervals();
        
        IntervalDomain newIntervalDomain = null;
        
        // the addition must be done between first list intervals and second list intervals
        for (int i = 0 ; i < v1Intervals.size() ; i++) {
                Interval interval1 = (Interval) v1Intervals.get(i);
                for (int j = 0 ; j < v2Intervals.size() ; j++) {
                        Interval interval2 = (Interval) v2Intervals.get(j);
                        
                        // here it is calculated new single interval
                        long dividedValue1 = (interval1.getLowerBound() == Long.MIN_VALUE || interval2.getLowerBound() == Long.MIN_VALUE) ?
                                                      Long.MIN_VALUE : 
                                                          ((interval1.getLowerBound() == Long.MAX_VALUE || interval2.getLowerBound() == Long.MAX_VALUE) ?
                                                           Long.MAX_VALUE :
                                                           interval1.getLowerBound() * interval2.getLowerBound()); 
                                
                        long dividedValue2 = (interval1.getLowerBound() == Long.MIN_VALUE || interval2.getUpperBound() == Long.MIN_VALUE) ?
                                          Long.MIN_VALUE : 
                                                  ((interval1.getLowerBound() == Long.MAX_VALUE || interval2.getUpperBound() == Long.MAX_VALUE) ?
                                                   Long.MAX_VALUE :
                                                   interval1.getLowerBound() * interval2.getUpperBound()); 
                                
                        long dividedValue3 = (interval1.getUpperBound() == Long.MIN_VALUE || interval2.getLowerBound() == Long.MIN_VALUE) ?
                                  Long.MIN_VALUE : 
                                          ((interval1.getUpperBound() == Long.MAX_VALUE || interval2.getLowerBound() == Long.MAX_VALUE) ?
                                           Long.MAX_VALUE :
                                           interval1.getUpperBound() * interval2.getLowerBound());
                                
                        long dividedValue4 = (interval1.getUpperBound() == Long.MIN_VALUE || interval2.getUpperBound() == Long.MIN_VALUE) ?
                                  Long.MIN_VALUE : 
                                  ((interval1.getUpperBound() == Long.MAX_VALUE || interval2.getUpperBound() == Long.MAX_VALUE) ?
                                   Long.MAX_VALUE :
                                   interval1.getUpperBound() * interval2.getUpperBound()); 
                        
                        long newLowBound = calculateMin(dividedValue1, dividedValue2, dividedValue3, dividedValue4);
                        long newUpBound = calculateMax(dividedValue1, dividedValue2, dividedValue3, dividedValue4);
                        
                        if (newIntervalDomain == null) { // first time i create an interval for this list
                                List firstInterval = new ArrayList();
                                firstInterval.add(new Interval(newLowBound, newUpBound));
                                newIntervalDomain = new IntervalDomain(firstInterval);
                        } else {
                                newIntervalDomain.insertNewInterval(new Interval(newLowBound, newUpBound));
                        }
                }
        }
        
        return newIntervalDomain;
        
//    if(!checkType(v1, v2))
//        throw new SemanticException("I cannot perform an arithmetic operations with different domains",
//name.ferrara.pietro.checkmate.abstractdomain.SemanticException.Error.DomainError);
//    IntervalDomain val1 = (IntervalDomain)v1;
//    IntervalDomain val2 = (IntervalDomain)v2;
//    long l1 = val1.lowerBound * val2.lowerBound;
//    long l2 = val1.lowerBound * val2.upperBound;
//    long l3 = val1.upperBound * val2.lowerBound;
//    long l4 = val1.upperBound * val2.upperBound;
//    if(val1.upperBound == 0x7fffffffffffffffL || val2.upperBound ==
//0x7fffffffffffffffL)
//    {
//        if(val1.upperBound == 0x7fffffffffffffffL)
//        {
//            l3 = 0x7fffffffffffffffL;
//            l4 = 0x7fffffffffffffffL;
//        }
//        if(val2.upperBound == 0x7fffffffffffffffL)
//        {
//            l2 = 0x7fffffffffffffffL;
//            l4 = 0x7fffffffffffffffL;
//        }
//    }
//    if(val1.lowerBound == 0x8000000000000000L || val2.lowerBound ==
//0x8000000000000000L)
//    {
//        if(val1.lowerBound == 0x8000000000000000L)
//        {
//            l1 = 0x8000000000000000L;
//            l2 = 0x8000000000000000L;
//        }
//        if(val2.lowerBound == 0x8000000000000000L)
//        {
//            l1 = 0x8000000000000000L;
//            l3 = 0x8000000000000000L;
//        }
//    }
//    long min = min(l1, l2, l3, l4);
//    long max = max(l1, l2, l3, l4);
//    return new IntervalDomain(min, max, v1.categoryType() == 1);
}

public NumericalValue subtract(NumericalValue arg0, NumericalValue arg1)
        throws SemanticException {
        List v1Intervals = ((IntervalDomain) arg0).getIntervals();
        List v2Intervals = ((IntervalDomain) arg1).getIntervals();
        
        IntervalDomain newIntervalDomain = null;
        
        // the addition must be done between first list intervals and second list intervals
        for (int i = 0 ; i < v1Intervals.size() ; i++) {
                Interval interval1 = (Interval) v1Intervals.get(i);
                for (int j = 0 ; j < v2Intervals.size() ; j++) {
                        Interval interval2 = (Interval) v2Intervals.get(j);
                        
                        // here it is calculated new single interval
                        long subtractedValue1 = (interval1.getLowerBound() == Long.MIN_VALUE || interval2.getLowerBound() == Long.MIN_VALUE) ?
                                                                         Long.MIN_VALUE : 
                                                                     ((interval1.getLowerBound() == Long.MAX_VALUE || interval2.getLowerBound() == Long.MAX_VALUE) ?
                                                                     Long.MAX_VALUE :
                                                                         interval1.getLowerBound() - interval2.getLowerBound()); 

                        long subtractedValue2 = (interval1.getLowerBound() == Long.MIN_VALUE || interval2.getUpperBound() == Long.MIN_VALUE) ?
                                        Long.MIN_VALUE : 
                                                ((interval1.getLowerBound() == Long.MAX_VALUE || interval2.getUpperBound() == Long.MAX_VALUE) ?
                                                                Long.MAX_VALUE :
                                                                        interval1.getLowerBound() - interval2.getUpperBound()); 

                        long subtractedValue3 = (interval1.getUpperBound() == Long.MIN_VALUE || interval2.getLowerBound() == Long.MIN_VALUE) ?
                                        Long.MIN_VALUE : 
                                                ((interval1.getUpperBound() == Long.MAX_VALUE || interval2.getLowerBound() == Long.MAX_VALUE) ?
                                                                Long.MAX_VALUE :
                                                                        interval1.getUpperBound() - interval2.getLowerBound());

                        long subtractedValue4 = (interval1.getUpperBound() == Long.MIN_VALUE || interval2.getUpperBound() == Long.MIN_VALUE) ?
                                        Long.MIN_VALUE : 
                                                ((interval1.getUpperBound() == Long.MAX_VALUE || interval2.getUpperBound() == Long.MAX_VALUE) ?
                                                                Long.MAX_VALUE :
                                                                        interval1.getUpperBound() - interval2.getUpperBound()); 

                        long newLowBound = calculateMin(subtractedValue1, subtractedValue2, subtractedValue3, subtractedValue4);
                        long newUpBound = calculateMax(subtractedValue1, subtractedValue2, subtractedValue3, subtractedValue4);
                        
//                      long newLowBound = (interval1.getLowerBound() == Long.MIN_VALUE || interval2.getLowerBound() == Long.MIN_VALUE) ?
//                                      Long.MIN_VALUE : 
//                                      ((interval1.getLowerBound() == Long.MAX_VALUE || interval2.getLowerBound() == Long.MAX_VALUE) ?
//                                   Long.MAX_VALUE :
//                                   interval1.getLowerBound() - interval2.getLowerBound());  
//                              
//                      long newUpBound = (interval1.getUpperBound() == Long.MIN_VALUE || interval2.getUpperBound() == Long.MIN_VALUE) ?
//                                         Long.MIN_VALUE : 
//                                     ((interval1.getUpperBound() == Long.MAX_VALUE || interval2.getUpperBound() == Long.MAX_VALUE) ?
//                                  Long.MAX_VALUE :
//                                  interval1.getUpperBound() - interval2.getUpperBound()); 
                        
                        if (newIntervalDomain == null) { // first time i create an interval for this list
                                List firstInterval = new ArrayList();
                                firstInterval.add(new Interval(newLowBound, newUpBound));
                                newIntervalDomain = new IntervalDomain(firstInterval);
                        } else {
                                newIntervalDomain.insertNewInterval(new Interval(newLowBound, newUpBound));
                        }
                }
        }
        
        return newIntervalDomain;
//    if(!checkType(v1, v2))
//        throw new SemanticException("I cannot perform an arithmetic operations with different domains",
//name.ferrara.pietro.checkmate.abstractdomain.SemanticException.Error.DomainError);
//    IntervalDomain val1 = (IntervalDomain)v1;
//    IntervalDomain val2 = (IntervalDomain)v2;
//    long l1 = val1.lowerBound - val2.lowerBound;
//    long l2 = val1.lowerBound - val2.upperBound;
//    long l3 = val1.upperBound - val2.lowerBound;
//    long l4 = val1.upperBound - val2.upperBound;
//    long up;
//    if(val1.upperBound == 0x7fffffffffffffffL || val2.lowerBound ==
//0x8000000000000000L)
//        up = 0x7fffffffffffffffL;
//    else
//        up = max(l1, l2, l3, l4);
//    long down;
//    if(val1.lowerBound == 0x8000000000000000L || val2.upperBound ==
//0x7fffffffffffffffL)
//        down = 0x8000000000000000L;
//    else
//        down = min(l1, l2, l3, l4);
//    return new IntervalDomain(down, up, v1.categoryType() == 1);
}

public BooleanDomain testFalse(NumericalValue arg0, NumericalValue arg1,
        ComparisonOperator arg2) throws SemanticException {
//  if(!checkType(v1, v2))
//  throw new SemanticException("I cannot perform a comparison with different domains",
//name.ferrara.pietro.checkmate.abstractdomain.SemanticException.Error.DomainError);
        
        if (arg2.compareTo(ComparisonOperator.equal) == 0) {
                return testTrue(arg0, arg1, ComparisonOperator.notequal);
        }
        
        if (arg2.compareTo(ComparisonOperator.notequal) == 0) {
                return testTrue(arg0, arg1, ComparisonOperator.equal);
        }
        
        if (arg2.compareTo(ComparisonOperator.greater) == 0) {
                return testTrue(arg0, arg1, ComparisonOperator.lessequal);
        }
        
        if (arg2.compareTo(ComparisonOperator.greaterequal) == 0) {
                return testTrue(arg0, arg1, ComparisonOperator.less);
        }
        
        if (arg2.compareTo(ComparisonOperator.less) == 0) {
                return testTrue(arg0, arg1, ComparisonOperator.greaterequal);
        }
        
        if (arg2.compareTo(ComparisonOperator.lessequal) == 0) {
                return testTrue(arg0, arg1, ComparisonOperator.greater);
        }
        
////switch(arg2.ordinal())
////{
////case 1: // '\001'
////  
////
////case 2: // '\002'
////  
////
////case 3: // '\003'
////  return testTrue(arg0, arg1, ComparisonOperator.lessequal);
////
////case 4: // '\004'
////  return testTrue(arg0, arg1, ComparisonOperator.less);
////
////case 5: // '\005'
////  return testTrue(arg0, arg1, ComparisonOperator.greaterequal);
////
////case 6: // '\006'
//  return testTrue(arg0, arg1, ComparisonOperator.greater);
//}
throw new SemanticException("Conditional operator not yet supported",
name.ferrara.pietro.checkmate.abstractdomain.SemanticException.Error.NumericalDomain);
}

public BooleanDomain testTrue(NumericalValue arg0, NumericalValue arg1,
        ComparisonOperator arg2) throws SemanticException {
//  if(!checkType(v1, v2))
//  throw new SemanticException("I cannot perform a comparison with different domains",
//name.ferrara.pietro.checkmate.abstractdomain.SemanticException.Error.DomainError);

long v1LowBound = ((IntervalDomain) arg0).getLowestDomainBound();
long v1UpBound = ((IntervalDomain) arg0).getUppestDomainBound();

long v2LowBound = ((IntervalDomain) arg1).getLowestDomainBound();
long v2UpBound = ((IntervalDomain) arg1).getUppestDomainBound();

//IntervalDomain val1 = (IntervalDomain)v1;
//IntervalDomain val2 = (IntervalDomain)v2;

if(((IntervalDomain) arg0).isBottom() || ((IntervalDomain) arg1).isBottom())
  return BooleanDomain.Bottom;
if(((IntervalDomain) arg0).isTop() || ((IntervalDomain) arg1).isTop())
  return BooleanDomain.Top;

// EQUAL - this is the conditions for Equal response
if (arg2.compareTo(ComparisonOperator.equal) == 0) {
        // if v1LOW = v2UP & v1UP = v2LOW
        if(v1LowBound == v2UpBound && v1UpBound == v2LowBound) {
      return BooleanDomain.True;
        }
        
        if (v1LowBound >= v2UpBound || v2LowBound >= v1UpBound) {
                return BooleanDomain.False;
        }
        
        return BooleanDomain.Top;
}

if (arg2.compareTo(ComparisonOperator.notequal) == 0) {
        if(v1LowBound == v2UpBound && v1UpBound == v2LowBound) {
      return BooleanDomain.False;
        }
        
        if (v1LowBound >= v2UpBound || v2LowBound >= v1UpBound) {
                return BooleanDomain.True;
        } 
        
        return BooleanDomain.Top;
}

if (arg2.compareTo(ComparisonOperator.greater) == 0) {
        if(v1LowBound > v2UpBound) {
      return BooleanDomain.True;
        }
  if(v1UpBound <= v2LowBound) {
      return BooleanDomain.False;
  }

  return BooleanDomain.Top;
}

if (arg2.compareTo(ComparisonOperator.greaterequal) == 0) {
        if(v1LowBound >= v2UpBound) {
      return BooleanDomain.True;
        }
  if(v1UpBound < v2LowBound) {
      return BooleanDomain.False;
  }

  return BooleanDomain.Top;
}

if (arg2.compareTo(ComparisonOperator.less) == 0) {
        if(v1UpBound < v2LowBound) {
      return BooleanDomain.True;
        }
  if(v1LowBound >= v2UpBound) {
      return BooleanDomain.False;
  }

  return BooleanDomain.Top;
}

if (arg2.compareTo(ComparisonOperator.lessequal) == 0) {
        if(v1UpBound <= v2LowBound) {
      return BooleanDomain.True;
        }
  if(v1LowBound > v2UpBound) {
      return BooleanDomain.False;
  }

  return BooleanDomain.Top;
}

return BooleanDomain.Top;

//switch(op.ordinal())
//{
//case 1: // '\001'   -- EQUAL
//  
//
//case 2: // '\002'   -- NOTEQUAL
//  
//
//case 3: // '\003'   -- GREATER
//
//
//case 4: // '\004'   -- GREATEREQUAL
//
//
//case 5: // '\005'   -- LESS
//
//
//case 6: // '\006'    -- LESSEQUAL
//
//}
//throw new SemanticException("Conditional operator not yet supported",
//name.ferrara.pietro.checkmate.abstractdomain.SemanticException.Error.NumericalDomain);
}

public String toString() {
        String value = "";
        
        for (int i = 0 ; i < this.intervals.size() ; i++) {
                if (i > 0) {
                        value += ", ";
                }
                Interval interval = (Interval) this.intervals.get(i);
                value = value + "[" + interval.getLowerBound() + ".." + interval.getUpperBound() + "]";
        }
        
        return value;
//    String left = (new StringBuilder(String.valueOf(lowerBound))).toString();
//    String right = (new StringBuilder(String.valueOf(upperBound))).toString();
//    if(lowerBound == 0x8000000000000000L)
//        left = "-inf";
//    if(upperBound == 0x7fffffffffffffffL)
//        right = "+inf";
//    return (new
//StringBuilder("[")).append(left).append("..").append(right).append("]").toString();
}

public NumericalValue top(boolean arg0) {
        return new IntervalDomain(new Interval(Long.MIN_VALUE, Long.MAX_VALUE));
    //return new IntervalDomain(0x8000000000000000L, 0x7fffffffffffffffL, firstType1);
}

public NumericalValue widening(NumericalValue arg0, NumericalValue arg1)
        throws SemanticException {
//  if(!checkType(v1, v2))
//  throw new SemanticException("I cannot perform an arithmetic operations with different domains", name.ferrara.pietro.checkmate.abstractdomain.SemanticException.Error.DomainError);

        IntervalDomain first = (IntervalDomain) arg0;
        IntervalDomain second = (IntervalDomain) arg1;
        
        IntervalDomain newIntervalDomain = null;
        
        IntervalDomain lub = (IntervalDomain) lub(first, second);
        
        int listSize = lub.getIntervals().size();
        
//      if (lub.getLowestDomainBound() == Long.MIN_VALUE) {
//              listSize--;
//      }
//      
//      if (lub.getUppestDomainBound() == Long.MAX_VALUE) {
//              listSize--;
//      }
        
        // we'll verify if the upper bound can be greater than the previous value
        if (first.getUppestDomainBound() > second.getUppestDomainBound() || first.getUppestDomainBound() < second.getUppestDomainBound()) {
                if (lub.getIntervals().size() == 1) {
                        newIntervalDomain = new IntervalDomain(new Interval(lub.getLowestDomainBound(), Long.MAX_VALUE));
                } else {
                        List newIntervals = null;
                        //newIntervals = lub.getIntervals().subList(lub.getIntervals().size() - (1 > listSize ? listSize : 1), lub.getIntervals().size());
                        if (lub.getLowestDomainBound() < 0) {
                                //newIntervals = lub.getIntervals().subList(0, 2 > listSize ? listSize : 2);
                                newIntervals = lub.getIntervals().subList(lub.getIntervals().size() - (2 > listSize ? listSize : 2), lub.getIntervals().size());
                        } else {
                                newIntervals = lub.getIntervals().subList(0, 2 > listSize ? listSize : 2);
                                //newIntervals = lub.getIntervals().subList(lub.getIntervals().size() - (2 > listSize ? listSize : 2), lub.getIntervals().size());
                        }
                        
                        IntervalDomain tempIntervalDomain = new IntervalDomain(newIntervals);
                        if (tempIntervalDomain.getUppestDomainBound() != Long.MAX_VALUE) {
                                newIntervals.add(new Interval(tempIntervalDomain.getUppestDomainBound(), Long.MAX_VALUE));
                        }
                        newIntervalDomain = tempIntervalDomain;
                }
        }
        
        
        if (first.getLowestDomainBound() < second.getLowestDomainBound() || first.getLowestDomainBound() > second.getLowestDomainBound()) {
                if (lub.getIntervals().size() == 1) {
                        if (newIntervalDomain == null) {
                                newIntervalDomain = new IntervalDomain(new Interval(Long.MIN_VALUE, lub.getUppestDomainBound()));
                        } else {
                                newIntervalDomain = new IntervalDomain(new Interval(Long.MIN_VALUE, newIntervalDomain.getUppestDomainBound()));
                        }
                } else {
                        if (newIntervalDomain == null) {
                                List newIntervals = null;
                                //newIntervals = lub.getIntervals().subList(0, 1 > listSize ? listSize : 1);
                                if (lub.getLowestDomainBound() >= 0) {
                                        //newIntervals = lub.getIntervals().subList(lub.getIntervals().size() - (2 > listSize ? listSize : 2), lub.getIntervals().size());
                                        newIntervals = lub.getIntervals().subList(0, 2 > listSize ? listSize : 2);
                                } else {
                                        //newIntervals = lub.getIntervals().subList(0, 2 > listSize ? listSize : 2);
                                        newIntervals = lub.getIntervals().subList(lub.getIntervals().size() - (2 > listSize ? listSize : 2), lub.getIntervals().size());
                                }
                                
                                
                                IntervalDomain tempIntervalDomain = new IntervalDomain(newIntervals);
                                if (tempIntervalDomain.getLowestDomainBound() != Long.MIN_VALUE) {
                                        newIntervals.add(0, new Interval(Long.MIN_VALUE, tempIntervalDomain.getLowestDomainBound()));
                                }
                                newIntervalDomain = tempIntervalDomain;
                        } else {
                                List newIntervals = newIntervalDomain.getIntervals();
                                
                                IntervalDomain tempIntervalDomain = new IntervalDomain(newIntervals);
                                if (tempIntervalDomain.getLowestDomainBound() != Long.MIN_VALUE) {
                                        newIntervals.add(0, new Interval(Long.MIN_VALUE, tempIntervalDomain.getLowestDomainBound()));
                                }
                                newIntervalDomain = tempIntervalDomain;
                        }
                }
        }
        
        if (newIntervalDomain != null) {
                return newIntervalDomain;
        }
        
        return lub;
        


//IntervalDomain val1 = (IntervalDomain)v1;
//IntervalDomain val2 = (IntervalDomain)v2;
//
//long min = min(val1.lowerBound, val2.lowerBound);
//long max = max(val1.upperBound, val2.upperBound);
//if(val2.upperBound > val1.upperBound || val1.upperBound > val2.upperBound)
//  max = 0x7fffffffffffffffL;
//if(val2.lowerBound < val1.lowerBound || val1.lowerBound < val2.lowerBound)
//  min = 0x8000000000000000L;
//return new IntervalDomain(min, max, v1.categoryType() == 1);
}

        
        /*
         * Represents the interval
         */
    private class Interval {
        // this is the lower bound of the interval
        private long lowerBound;
        // this is the upper bound of the interval
        private long upperBound;
        
        /**
         * Create a new instance of Interval with default bounds
         *  lowerBound = Long.MIN_VALUE
         *  upperBound = Long.MIN_VALUE
         */
        public Interval() {
                this.lowerBound = Long.MIN_VALUE;
                this.upperBound = Long.MIN_VALUE;
        }
        
        /**
         * Create a new instance of Interval from parameters;
         * if parameters are formal incorrect (upperBound < lowerBound)
         * two parameters will be swapped
         * @param minValue
         * @param maxValue
         */
        public Interval(long lowerBound, long upperBound) {
                if (upperBound < lowerBound) {
                        this.lowerBound = upperBound;
                        this.upperBound = lowerBound;
                } else {
                        this.lowerBound = lowerBound;
                        this.upperBound = upperBound;
                }
        }

        /**
         * 
         * @return the lower bound of this
         */
                public long getLowerBound() {
                        return lowerBound;
                }

                /**
                 * 
                 * @param lowerBound should be lower or equal than upperBound
                 *                      but there is no control 
                 */
                public void setLowerBound(long lowerBound) {
                        this.lowerBound = lowerBound;
                }

                /**
                 * 
                 * @return the upper bound of this
                 */
                public long getUpperBound() {
                        return upperBound;
                }

                /**
                 * 
                 * @param upperBound should be upper or equal than lowerBound
                 *                      but there is no control
                 */
                public void setUpperBound(long upperBound) {
                        this.upperBound = upperBound;
                }
                
                public Interval clona() {
                        return new Interval(this.lowerBound, this.upperBound);
                }
    }
    

//    private long lowerBound;
//    private long upperBound;
//    private boolean firstType;
//    private static int
//$SWITCH_TABLE$name$ferrara$pietro$checkmate$abstractdomain$ComparisonOperator[];
}
