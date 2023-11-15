(ns sechs-nimmt.spiel)

(defn -main [] (println "Spiel mit mir!"))
(require '[clojure.pprint :as pp])

(def spiel-beispiel
  { :hand {"Mensch" [45 70 66 61 48 85 80 54 10 30] "Maschine" [79 98 9 76 20 82 44 75 36 65] }
    :reihe [[52] [2 34 37 49 55] [11 25 81] [39]]
    :punkte { "Peter" 0 "Maschine" 0 }} )

;;stapel [74 68 4 62 94 56 53 38 89 103 26 29 1 95 42 8 96 15 86 27 58 5 91 90 17 67 40 87 19 6 23 102 24 78 13 32 43 92 100 69 28 84 31 77 14 12 63 97 22 101 93 41 99 60 88 46 3 21 73 64 83 51 35 72 7 47 50 57 16 71 33 59]

(defn hornochsen
  "Wie viele Hornochsen gibt diese Karte?"
  [karte]
  (cond
    (= 0 (mod karte 11)) 5
    (= 0 (mod karte 10)) 3
    (= 0 (mod karte 5)) 2
    :sonst 1))

(defn aufbau
  "Verteile Karten an Liste von Spielnamen"
  [spieler]
  (let [stapel (shuffle (range 1 105))]
    (hash-map
      :reihe (map #(list %) (take 4 stapel))
      :hand (zipmap  spieler (partition 10 (drop 4 stapel)))
      :punkte (zipmap spieler (repeat 0) ) )))
