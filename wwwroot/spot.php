<?php


class spot
{
    public $ap;
    public int $x;
    public int $y;

    /**
     * spot constructor.
     * @param array $ap
     * @param int $x
     * @param int $y
     */
    public function __construct(array $ap, int $x, int $y)
    {
        $this->ap = $ap;
        $this->x = $x;
        $this->y = $y;
    }
}
