"Shows a X button in Roam block. Clicking the button leads to deleting the block including children. Very useful for mobile Roam where you can (using a simple text shortcut and auto-paste the {{roam/render: ((blockid))}}) create the button."

(ns my-custom-roam-22042022
  (:require
   [roam.block :as block]))

(defn erase-block [block-uid]
    (block/delete
        {:block {:uid block-uid}})
      (.then #(js/console.log "ok"))
      (.catch #(js/console.log "fail" %)))

(defn erase-block-btn [block-uid]
    [:span
     {:draggable true
      :style    {:border "2px solid #FFC107"
                 :cursor "pointer"
                 :border-radius "6px"
                 :background-color "#CE841866"
                 :border-bottom "solid 2px"
                 :border-right "solid 2px"
                 :padding "2px"}
      :on-click (fn [evt] (erase-block block-uid))}
    " ❌ "])

(defn main [{:keys [block-uid]} & args]
    (erase-block-btn block-uid))
