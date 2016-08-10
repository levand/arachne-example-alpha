(require '[arachne.core.dsl :as core])
(require '[arachne.http.dsl :as http])
(require '[arachne.pedestal.dsl :as ped])

(core/runtime :arachne.example.alpha/runtime [:arachne.example.alpha/server])

(core/component :arachne.example.alpha/ticktock {}
  'arachne.example.alpha.ticktock/->TickTock)

(core/component :arachne.example.alpha/status
  {:arachne.example.alpha/ticktock :data-source}
  'arachne.example.alpha.web/->StatusHandler)

(http/server :arachne.example.alpha/server 8080

  (http/endpoint :get "/status" :arachne.example.alpha/status)

  )





