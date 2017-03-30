package justf

/**
 * Produces an effect from the container F.
 * The type [[justf.Foreach]] is an alias for this.
 *
 * Source Category:
 * objects: Scala types
 * arrows: Unit is final all other types are initial
 *
 * @tparam F the container
 */
trait Sink[F[_]]{
  /**
   * Performs the sinking action.
   * @tparam A the type within the container
   * @param f the arrow from A to Unit
   * @return an arrow from F[A] to F[Unit]
   */
  def sink[A](f: A => Unit): F[A] => F[Unit]
}
