package justf

import org.scalatest.WordSpec
import org.scalacheck.Prop._

class FilterSpec extends WordSpec{
  val f: Int => Boolean = i => 0 < i
  val F: Filter[List] = new Filter[List]{
    def filter[A](f: A => Boolean): List[A] => List[A] = {l =>
      l.filter(f)
    }
  }
  "A Filter" should{
    "do as it is told" in{
      forAll{fa: List[Int] =>
        fa.filter(f) === F.filter(f)(fa)
      }
    }
    
    "have filter be the opposite of filterNot" in{
      forAll{fa: List[Int] =>
        val filtered = F.filter(f)(fa)
        val filteredNot = F.filterNot(f)(fa)
        
        fa.sorted === (filtered ++ filteredNot).sorted
      }
    }
  }
}