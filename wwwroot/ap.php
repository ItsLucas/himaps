<?php


class ap {
    public String $bssid;
    public String $ssid;
    public int $strength;

    /**
     * ap constructor.
     * @param String $bssid
     * @param String $ssid
     * @param int $strength
     */
    public function __construct(string $bssid, string $ssid, int $strength)
    {
        $this->bssid = $bssid;
        $this->ssid = $ssid;
        $this->strength = $strength;
    }

}
