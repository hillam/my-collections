(ns my-collections.core-test
  (:require [clojure.test :refer :all]
            [my-collections.core :refer :all :as my]))

; Vector of test collections
(def test-colls [
  (range 1 10)
  (list "1" "2" "3")
])

(defn compare-fns
  "Test that the results of the two given functions are the same
  for all given collections."
  [my-fn core-fn coll]
    (is (= (my-fn   coll)
           (core-fn coll)))
)

(deftest first-test
  (testing "my/first should always match clojure.core's"
    (map (partial compare-fns my/first first) test-colls))
)

(deftest rest-test
  (testing "my/rest should always match clojure.core's"
    (map (partial compare-fns my/rest rest) test-colls)))

