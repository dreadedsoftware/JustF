package justf

/**
 * Removes items from the collection.
 *
 * Source Category:
 * objects are A (monoidal)
 * arrows, just the identity
 *
 */
trait Remove[F[_]]{
  def remove[A](f: A): F[A] => F[A]
}
