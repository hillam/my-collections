(ns my-collections.core
  (:gen-class))

(defn first
  "Return the first item in the given collection"
  [[head & tail]]
  head
)

(defn rest
  "Return all but the first item from the given collection"
  [[head & tail]]
  (if (empty? tail) '() tail)
)

