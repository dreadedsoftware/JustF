package justf

/**
 * defines a filter over an F. Given a function A => Boolean
 * returns a function which will accept an F[A] and
 * return a filtered F[A].
 *
 * Not an embedding.
 * Source Category:
 * objects: A (monoidal)
 * arrows: functions A => Boolean
 *
 * @tparam F the container type to filter over.
 */
trait Filter[F[_]]{
  /**
   * performs the filter operation
   * @tparam A the type within the container
   * @param f The filter function
   * @return A function F[A] => F[A] which represents
   * a filter operation for F with type A.
   */
  def filter[A](f: A => Boolean): F[A] => F[A]
  
  final def filterNot[A](f: A => Boolean): F[A] => F[A] =
    filter(a => !f(a))
}
