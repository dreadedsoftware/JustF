package justf

trait Sink[F[_]]{
  def sink[A](f: A => Unit): F[A] => F[Unit]
}
