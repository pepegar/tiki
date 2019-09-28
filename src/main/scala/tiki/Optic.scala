package tiki

// -- | Wrapper newtype for the whole family of optics.
// --
// -- The first parameter @k@ identifies the particular optic kind (e.g. 'A_Lens'
// -- or 'A_Traversal').
// --
// -- The parameter @is@ is a list of types available as indices.  This will
// -- typically be 'NoIx' for unindexed optics, or 'WithIx' for optics with a
// -- single index. See the "Indexed optics" section of the overview documentation
// -- in the @Optics@ module of the main @optics@ package for more details.
// --
// -- The parameters @s@ and @t@ represent the "big" structure,
// -- whereas @a@ and @b@ represent the "small" structure.
// --
// newtype Optic (k :: OpticKind) (is :: IxList) s t a b = Optic
//   { getOptic :: forall p i. Profunctor p
//              => Optic_ k p i (Curry is i) s t a b
//   }

// -- | Common special case of 'Optic' where source and target types are equal.
// --
// -- Here, we need only one "big" and one "small" type. For lenses, this
// -- means that in the restricted form we cannot do type-changing updates.
// --
// type Optic' k is s a = Optic k is s s a a

// -- | Type representing the various kinds of optics.
// --
// -- The tag parameter @k@ is translated into constraints on @p@
// -- via the type family 'Constraints'.
// --
// type Optic_ k p i j s t a b = Constraints k p => Optic__ p i j s t a b

// -- | Optic internally as a profunctor transformation.
// type Optic__ p i j s t a b = p i a b -> p j s t

trait Optic[K, S, T, A, B] {}
