(ns mecca.tuna.app
  (:require [goog.dom :as gdom]
            [reagent.core :as r]))

(defn mecca []
  [:div
   [:h1 "mecca-tuna"]
   ])

(defn get-app-element []
  (gdom/getElement "root"))

(defn mount [el]
  (r/render-component [mecca] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

;; start is called by init and after code reloading finishes
(defn ^:dev/after-load start []
  (mount-app-element)
  (js/console.log "start"))

(defn ^:export init []
  ;; init is called ONCE when the page loads
  ;; this is called in the index.html and must be exported
  ;; so it is available even in :advanced release builds
  (js/console.log "init")
  (start))

;; this is called before any code is reloaded
(defn ^:dev/before-load stop []
  (js/console.log "stop"))