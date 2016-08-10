(require '[arachne.core.dsl :as core])

(core/runtime :arachne.example.alpha/runtime [:arachne.example.alpha/ticktock])

(core/component :arachne.example.alpha/ticktock {}
  'arachne.example.alpha.ticktock/->TickTock)

