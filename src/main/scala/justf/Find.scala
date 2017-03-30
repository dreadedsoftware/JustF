package justf

/**
 * Locates an A within an F.
 *
 * Source Category:
 * objects: Scala types
 * arrows: Boolean is final all other types are initial
 * 
 * Target Category: Cokleisli F A Boolean
 * @tparam F the container
 */
trait Find[F[_]]{
  def find[A](f: A => Boolean): F[A] => Boolean
}
