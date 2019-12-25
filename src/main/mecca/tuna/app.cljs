(ns mecca.tuna.app
  (:require
   [reagent.core :as r]
   [promesa.core :as p]))

(defn initialize-audio []
  (let [ctx      (js/window.AudioContext.)
        analyser (.createAnalyser ctx)]
    (-> (.getUserMedia (.-mediaDevices js/navigator) (clj->js {:audio true}))
        (p/chain
         (fn [stream]
           (.createMediaStreamSource ctx stream))
         (fn [mss]
           (.connect mss analyser))))))

(defn mecca []
  [:div
   [:h1 "mecca-tuna"]])

(defn render []
  (r/render [mecca]
            (.getElementById js/document "root")))

(defn ^:dev/after-load start []
  (render)
  (js/console.log "start"))

(defn ^:export init []
  (js/console.log "init")
  (start))

(defn ^:dev/before-load stop []
  (js/console.log "stop"))
