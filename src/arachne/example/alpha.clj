(ns arachne.example.alpha
  (:require [arachne.core :as arachne]
            [com.stuartsierra.component :as component]))

;; In a main function
(defn -main
  "Application entry point"
  [config-file & _]
  (let [cfg (arachne/build-config
              [:org.arachne-framework/arachne-pedestal]
              config-file)
        rt (arachne/runtime cfg :arachne.example.alpha/runtime)]

    (component/start rt)))


;; From the REPL
(comment

  (def cfg (arachne/build-config
             [:org.arachne-framework/arachne-pedestal]
             "config/system.clj"))

  (def rt (atom
            (arachne/runtime cfg :arachne.example.alpha/runtime)))

  (swap! rt component/start)
  (swap! rt component/stop)


  )